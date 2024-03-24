package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "city", schema = "my_book_shop_a", catalog = "")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "district_id")
    private int districtId;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private DistrictEntity DistrictByDistrictId;

    public DistrictEntity getDistrictByDistrictId() {
        return DistrictByDistrictId;
    }

    public void setDistrictByDistrictId(DistrictEntity districtByDistrictId) {
        DistrictByDistrictId = districtByDistrictId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id && districtId == that.districtId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, districtId);
    }
}
