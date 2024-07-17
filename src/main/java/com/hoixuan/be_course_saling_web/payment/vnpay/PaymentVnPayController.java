
package com.hoixuan.be_course_saling_web.payment.vnpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import com.hoixuan.be_course_saling_web.model.Wallet;
import com.hoixuan.be_course_saling_web.repository.IAppUserRepo;
import com.hoixuan.be_course_saling_web.repository.IRequestRechargeRepo;
import com.hoixuan.be_course_saling_web.service.BillService;
import com.hoixuan.be_course_saling_web.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/pay/vnpay")
public class PaymentVnPayController {
    public static final String URL_PAYPAL_SUCCESS = "success";
    public static final String URL_PAYPAL_CANCEL = "cancel";
    private Logger log = LoggerFactory.getLogger(getClass());
   @Autowired
    IRequestRechargeRepo requestRechargeRepo;
    @Autowired
    IAppUserRepo appUserRepo;
    @Autowired
    WalletService walletService;
    @Autowired
    BillService billService;


    @PostMapping("/{total}")
    protected ResponseEntity<?> create(@PathVariable long total, HttpServletRequest req) throws ServletException, IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        long totalVND = (Math.round(total *100 * 25000));
        total = (Math.round(total));
        String redirectUrl = "http://localhost:8081/api/pay/vnpay/" + URL_PAYPAL_SUCCESS + "?total=" + total+"&&username="+user.getUsername();
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        long amount = totalVND;
        String bankCode = "NCB";

        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", redirectUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        Map<String,String> map = new HashMap<>();
        map.put("url",paymentUrl);
        return ResponseEntity.ok(map);
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public ModelAndView successPay(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("success");
        long total = Long.parseLong(request.getParameter("total"));
        String username = request.getParameter("username");

        AppUser appUser = appUserRepo.findByUserName(username);
        Wallet wallet = walletService.findByIdUser(appUser.getIdUser());

        wallet.setMoney(wallet.getMoney() + total);
        Bill bill = new Bill();
        bill.setPaymentMethod("Online");
        bill.setContentBill("Banking VNPAY");
        bill.setTotalBill(total);
        bill.setStatus(true);
        Calendar cal = Calendar.getInstance();
        java.sql.Date date=new Date(cal.getTimeInMillis());
        bill.setCreateAt(date);
        bill.setAppUser(appUser);
        billService.save(bill);
        return modelAndView;
    }
}
