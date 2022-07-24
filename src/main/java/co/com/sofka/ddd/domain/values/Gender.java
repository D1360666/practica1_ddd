package co.com.sofka.ddd.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Gender implements ValueObject<String> {

    private final String sex;

    public Gender(String sex){
        try {
            this.sex = sex;
            if( sex != "M" ||sex != "F"){
                throw new IllegalArgumentException("Invalid gender");
            }
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;
        Gender gender = (Gender) o;
        return sex.equals(gender.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex);
    }
}
