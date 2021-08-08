package To.Do.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

}
