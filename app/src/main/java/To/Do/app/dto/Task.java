package To.Do.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Getter
@Setter
@Entity
public class Task {
    @GeneratedValue
    private Long id;

    private String title;

}
