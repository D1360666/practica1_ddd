package co.com.sofka.ddd.domain.events;

import co.com.sofka.ddd.domain.entities.Student;
import co.com.sofka.ddd.domain.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Team extends AggregateEvent<TeamIdentity> {
    protected Name name;
    protected Set<Student> students;
    public Team(TeamIdentity identity, Name name){
        this(identity);
        appendChange(new CreatedTeam(name)).apply();
    }

    public Team(TeamIdentity identity){
        subscribe(new TeamBehavior8this(this));
    }

    public static Team from(TeamIdentity aggregatedId, List<DomainEvent> list){
        Team team = new Team(aggregatedId);
        list.forEach(team::applyEvent);
        return team;
    }

    public void addNewStudent(Name name, Gender gender, DateOfBirth dateOfBirth){
        StudentIdentity studentIdentity = new StudentIdentity();
        appendChange(new AddedStudent(studentIdentity, name, gender, dateOfBirth)).apply();
    }

    public void removeStudent(StudentIdentity studentIdentity){
        appendChange(new RemovedStudent(studentIdentity)).apply();
    }

    public void updateName(Name newName){
        appendChange(new UpdateName(newName)).apply();
    }

    public void updateStudentName(StudentIdentity studentIdentity, Name name){
        appendChange(new UpdateStudent(studentIdentity, name)).apply();
    }

    public void applyScoreToStudent(StudentIdentity studentIdentity, Score scrore){
        appendChange(new UpdateScoreOfStudent(studentIdentity, score)).apply();
    }

    public Set<Student> students(){
        return students;
    }

    public String name(){
        return name.value();
    }

}
