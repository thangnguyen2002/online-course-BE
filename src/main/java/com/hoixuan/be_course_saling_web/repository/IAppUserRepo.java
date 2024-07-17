package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    @Query(nativeQuery = true, value = "select * from app_user where user_name like concat ('%',:name,'%');")
    AppUser findByUserNameS(@Param("name") String name);

    AppUser findByUserName(String name);
    public boolean existsByEmail(String email);

    AppUser findByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM course_saling_web.app_user a join app_user_roles r on a.id_user = r.app_user_id_user where r.roles_id = 2")
    List<AppUser> getAllAppUserUser();

    @Query(nativeQuery = true,value = "SELECT app_user_id_user FROM my_course where course_id_course = :idCourse")
    AppUser findAppUserByMyCourse(@Param("idCourse") long idCourse);
}
