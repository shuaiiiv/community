package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHib")
public class AlphaDaoHiberateImpl implements AlphaDao {

    @Override
    public String select() {
        return "Hiberate";
    }
}
