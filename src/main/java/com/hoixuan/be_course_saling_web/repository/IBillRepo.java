package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.model.TotalBillInMonth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepo extends CrudRepository<Bill,Long> {
    List<Bill> getBillsByAppUserIdUser(long idUser);
    List<Bill> getBillsByCourseIdCourse(long idCourse);
    @Query(nativeQuery = true,value = "select sum(total_bill) as totalBillInMonth from bill where MONTH(create_at) = :month ")
    TotalBillInMonth getTotalBillInMonth (@Param("month") long month);
}
