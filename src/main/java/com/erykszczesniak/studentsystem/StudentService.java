package com.erykszczesniak.studentsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    List<Student>listAll(){
      return studentRepository.findAll();
    }

      public void save(Student student) {
         studentRepository.save(student);
    }


      public Student get(long id){
       return studentRepository.findById(id).get();
    }

    public void delete(long id){
         studentRepository.deleteById(id);
    }
}
