package com.qing.entity.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author QingShuai
 * @Date 2023 04 29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotArticleView {

    private Long id;
    //标题
    private String title;

    //访问量
    private Integer clickNum;
}
