CREATE TABLE `spu`
(
    `id`                  varchar(60) NOT NULL COMMENT '主键',
    `name`                varchar(100)  DEFAULT NULL COMMENT 'SPu名',
    `intro`               varchar(200)  DEFAULT NULL COMMENT '简介',
    `brand_id`            int(11)       DEFAULT NULL COMMENT '品牌ID',
    `category_one_id`     int(20)       DEFAULT NULL COMMENT '—级分类',
    `category_two_id`     int(10)       DEFAULT NULL COMMENT '二级分类',
    `category_three_id`   int(10)       DEFAULT NULL COMMENT '三级分类',
    `images`              varchar(1000) DEFAULT NULL COMMENT '图片列表',
    `after_sales_service` varchar(50)   DEFAULT NULL COMMENT '售后服务',
    `content`             longtext COMMENT '介绍',
    `attribute_list`      varchar(3000) DEFAULT NULL COMMENT '规格列表',
    `is_marketable`       int(1)        DEFAULT '0' COMMENT '是否上架,0已下架，1已上架',
    `is_delete`           int(1)        DEFAULT '0' COMMENT '是否删除,0:未删除，1:已删除',
    `status`              int(1)        DEFAULT '0' COMMENT '审核状态，0∶未审核，1:已审核，2:审核不通过',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `sku`
(
    `id`            varchar(60)  NOT NULL COMMENT '商品id',
    `name`          varchar(200) NOT NULL COMMENT 'SKu名称',
    `price`         int(20)      NOT NULL DEFAULT '1' COMMENT '价格(分)',
    `num`           int(10)               DEFAULT '100' COMMENT '库存数量',
    `image`         varchar(200)          DEFAULT NULL COMMENT '商品图片',
    `images`        varchar(2000)         DEFAULT NULL COMMENT '商品图片列表',
    `create_time`   datetime              DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime              DEFAULT NULL COMMENT '更新时间',
    `spu_id`        varchar(60)           DEFAULT NULL COMMENT 'SPUID',
    `category_id`   int(10)               DEFAULT NULL COMMENT '类目ID',
    `category_name` varchar(200)          DEFAULT NULL COMMENT '类目名称',
    `brand_id`      int(11)               DEFAULT NULL COMMENT '品牌id ',
    `brand_name`    varchar(100)          DEFAULT NULL COMMENT '品牌名称',
    `sku_attribute` varchar(200)          DEFAULT NULL COMMENT '规格',
    `status`        int(1)                DEFAULT '1' COMMENT '商品状态1-正常，2-下架，3-删除',
    PRIMARY KEY (`id`),
    KEY `cid` (`category_id`),
    KEY `status` (`status`),
    KEY `updated` (`update_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品表';

CREATE TABLE `category`
(
    `id`        int(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
    `name`      varchar(50) DEFAULT NULL COMMENT '分类名称',
    `sort`      int(11)     DEFAULT NULL COMMENT '排序',
    `parent_id` int(20)     DEFAULT NULL COMMENT '上级ID',
    PRIMARY KEY (`id`),
    KEY `parent_id` (`parent_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11182
  DEFAULT CHARSET = utf8 COMMENT ='商品类目';

CREATE TABLE `category_brand`
(
    `category_id` int(11) NOT NULL COMMENT '分类ID',
    `brand_id`    int(11) NOT NULL COMMENT '品牌ID',
    PRIMARY KEY (`brand_id`, `category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `brand`
(
    `id`      int(11)      NOT NULL AUTO_INCREMENT COMMENT '品牌id',
    `name`    varchar(100) NOT NULL COMMENT '品牌名称',
    `image`   varchar(1000) DEFAULT '' COMMENT '品牌图片地址',
    `initial` varchar(1)    DEFAULT '' COMMENT '品牌的首字母',
    `sort`    int(11)       DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTo_INCREMENT = 14
  DEFAULT CHARSET = utf8 COMMENT ='品牌表';

CREATE TABLE `category_attr`
(
    `category_id` int(11) NOT NULL,
    `attr_id`     int(11) NOT NULL COMMENT '属性分类表',
    PRIMARY KEY (`category_id`, `attr_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `sku_attribute`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`    varchar(50)   DEFAULT NULL COMMENT '属性名称',
    `options` varchar(2000) DEFAULT NULL COMMENT '属性选项',
    `sort`    int(11)       DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;