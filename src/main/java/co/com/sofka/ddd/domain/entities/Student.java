package co.com.sofka.ddd.domain.entities;


import co.com.sofka.ddd.domain.values.*;
import co.com.sofka.domain.generic.Entity;

public class Student extends Entity<StudentIdentity> {
    protected Name name;
    protected Gender gender;
    protected DateOfBirth dateOfBirth;
    protected Score score;

    protected Student(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth){
        super(studentIdentity);
        this.name=name;
        this.gender=gender;
        this.dateOfBirth = dateOfBirth;
        this.score = new Score(0);
    }
    public Student(StudentIdentity entityId) {
        super(entityId);
    }

    public static Student from(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth){
        var student = new Student(studentIdentity);

    }
}
