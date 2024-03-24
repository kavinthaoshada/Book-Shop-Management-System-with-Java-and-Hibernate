package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book", schema = "my_book_shop_a", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "pages")
    private Integer pages;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "status_id")
    private int statusId;
    @Basic
    @Column(name = "book_condition_id")
    private int bookconditionId;
    @Basic
    @Column(name = "author_id")
    private int authorId;
    @Basic
    @Column(name = "publisher_id")
    private int publisherId;
    @Basic
    @Column(name = "language_id")
    private int languageId;
    @Basic
    @Column(name = "edition_id")
    private int editionId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private CategoryEntity categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private StatusEntity StatusByStatusId;
    @ManyToOne
    @JoinColumn(name = "book_condition_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private BookConditionEntity bookConditionByBookConditionId;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private AuthorEntity authorByAuthorId;
    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PublisherEntity publisherByPublisherId;
    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private LanguageEntity languageBylanguageId;
    @ManyToOne
    @JoinColumn(name = "edition_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private EditionEntity editionByEditionId;

    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public StatusEntity getStatusByStatusId() {
        return StatusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        StatusByStatusId = statusByStatusId;
    }

    public BookConditionEntity getConditionByConditionId() {
        return bookConditionByBookConditionId;
    }

    public void setConditionByConditionId(BookConditionEntity bookConditionByBookConditionId) {
        this.bookConditionByBookConditionId = bookConditionByBookConditionId;
    }

    public PublisherEntity getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(PublisherEntity publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }

    public LanguageEntity getLanguageBylanguageId() {
        return languageBylanguageId;
    }

    public void setLanguageBylanguageId(LanguageEntity languageBylanguageId) {
        this.languageBylanguageId = languageBylanguageId;
    }

    public EditionEntity getEditionByEditionId() {
        return editionByEditionId;
    }

    public void setEditionByEditionId(EditionEntity editionByEditionId) {
        this.editionByEditionId = editionByEditionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getConditionId() {
        return bookconditionId;
    }

    public void setConditionId(int conditionId) {
        this.bookconditionId = conditionId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && categoryId == that.categoryId && statusId == that.statusId && bookconditionId == that.bookconditionId && authorId == that.authorId && publisherId == that.publisherId && languageId == that.languageId && editionId == that.editionId && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(pages, that.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, pages, categoryId, statusId, bookconditionId, authorId, publisherId, languageId, editionId);
    }

    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
