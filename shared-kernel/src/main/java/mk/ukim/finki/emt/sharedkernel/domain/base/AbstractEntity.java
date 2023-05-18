package mk.ukim.finki.emt.sharedkernel.domain.base;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Getter
public class AbstractEntity <ID extends DomainObjectId>{

    @EmbeddedId
    private ID id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id, "Id must not be null");
    }

    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        this.id = Objects.requireNonNull(source.id, "Id must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
