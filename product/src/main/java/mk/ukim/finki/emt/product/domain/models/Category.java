package mk.ukim.finki.emt.product.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")

public class Category extends AbstractEntity<CategoryId> {

    private String name;
    private String description;
}