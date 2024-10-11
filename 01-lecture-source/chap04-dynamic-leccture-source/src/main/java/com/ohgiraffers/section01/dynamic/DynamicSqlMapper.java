package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {


    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);
}
