package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_has_address", schema = "my_book_shop_a", catalog = "")
public class UserHasAddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "line1")
    private String line1;
    @Basic
    @Column(name = "line2")
    private String line2;
    @Basic
    @Column(name = "users_email")
    private String usersEmail;
    @Basic
    @Column(name = "city_id")
    private int cityId;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, insertable = false, updatable = false)
    private UsersEntity usersByUsersEmail;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private CityEntity cityByCityId;

    public UsersEntity getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(UsersEntity usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHasAddressEntity that = (UserHasAddressEntity) o;
        return id == that.id && cityId == that.cityId && Objects.equals(line1, that.line1) && Objects.equals(line2, that.line2) && Objects.equals(usersEmail, that.usersEmail) && Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, line1, line2, usersEmail, cityId, postalCode);
    }

    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
