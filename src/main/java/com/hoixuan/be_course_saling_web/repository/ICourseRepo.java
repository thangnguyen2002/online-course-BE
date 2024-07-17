package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepo extends PagingAndSortingRepository<Course,Long> {
    Page<Course>findAllByNameCourseContaining(Pageable pageable,String name);
    Course findByIdCourse(long id);
@Query(nativeQuery = true,value = "SELECT * FROM course_saling_web.course where status_course = 1 order by id_course desc limit 1")
    Course findCourseNew();

    @Query(nativeQuery = true,value = "SELECT * FROM course where status_course = 1 order by enrolled desc limit 6")
    List<Course> getTrendingCourse ();
@Query(nativeQuery = true,value = "SELECT * FROM course c join instructor i on c.instructor_id_instructor = i.id_instructor "
        + "where status_course = 1" + " and"
        + " (:nameCourse is null or name_course like :nameCourse)" + " and"
        + " (:from is null or price_course >= :from)" + " and"
        + " (:to is null or price_course <= :to)" + " and"
        + " (:experience is null or i.experience >= :experience)" + " and"
        + " (:nameInstructor is null or i.name_instructor like  :nameInstructor )" + "and"
        + " (:rating is null or num_rating >= :rating)")
    List<Course> getAllCourseByCriteria(@Param("nameCourse") String nameCourse,
                                         @Param("from") int down,
                                         @Param("to") int up,
                                         @Param("experience") int experience,
                                         @Param("nameInstructor") String nameInstructor,
                                         @Param("rating") int rating);
}
