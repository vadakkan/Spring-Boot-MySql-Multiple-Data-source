package com.nitheesh.mvc.primary.domain;

import lombok.Data;

import javax.persistence.*;

@AttributeOverrides({
        @AttributeOverride(
                name = "ebookPublisher.name",
                column = @Column(name = "ebook_publisher_name")
        ),
        @AttributeOverride(
                name = "paperBackPublisher.name",
                column = @Column(name = "paper_back_publisher_name")
        )
})
@AssociationOverrides({
        @AssociationOverride(
                name = "ebookPublisher.country",
                joinColumns = @JoinColumn(name = "ebook_publisher_country_id")
        ),
        @AssociationOverride(
                name = "paperBackPublisher.country",
                joinColumns = @JoinColumn(name = "paper_back_publisher_country_id")
        )
})

@Entity(name = "Book")
@Table
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private Publisher ebookPublisher;

    private Publisher paperBackPublisher;


    @Embeddable
    @Data
    public static class Publisher {

        private String name;

        @ManyToOne(fetch = FetchType.LAZY)
        private Country country;


    }

}
