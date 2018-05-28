/*
MySQL Data Transfer
Source Host: localhost
Source Database: fishdb
Target Host: localhost
Target Database: fishdb
Date: 3/17/2017 7:50:32 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
CREATE TABLE `book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `book_category_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_bookcategoryid_idx` (`book_category_id`),
  CONSTRAINT `fk_book_bookcategoryid` FOREIGN KEY (`book_category_id`) REFERENCES `book_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
CREATE TABLE `book_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbm_d_item_img
-- ----------------------------
CREATE TABLE `tbm_d_item_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iditem` int(11) DEFAULT NULL,
  `descicon` char(50) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_d_order
-- ----------------------------
CREATE TABLE `tbm_d_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idhead` int(11) DEFAULT NULL,
  `invoorder` char(25) DEFAULT NULL,
  `iditm` int(11) DEFAULT NULL,
  `qtyitm` char(50) DEFAULT NULL,
  `itmprice` decimal(10,0) DEFAULT NULL,
  `priceid` int(11) DEFAULT NULL,
  `eventid` int(11) DEFAULT NULL,
  `discid` int(11) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=839 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_h_order
-- ----------------------------
CREATE TABLE `tbm_h_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idmember` int(11) DEFAULT NULL,
  `invoorder` char(25) DEFAULT NULL,
  `descorder` char(50) DEFAULT NULL,
  `detadd` varchar(150) DEFAULT NULL,
  `longadd` decimal(25,20) DEFAULT NULL,
  `latadd` decimal(25,20) DEFAULT NULL,
  `areaadd` varchar(150) DEFAULT NULL,
  `tglord` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `tglexp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ordtotal` decimal(10,0) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=464 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_item
-- ----------------------------
CREATE TABLE `tbm_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idmenu` int(11) DEFAULT NULL,
  `deschead` char(50) DEFAULT NULL,
  `desccont` varchar(255) DEFAULT NULL,
  `itemicon` char(50) DEFAULT NULL,
  `itmprice` decimal(10,0) DEFAULT NULL,
  `itmsat` char(15) DEFAULT NULL,
  `itmqty` decimal(10,0) DEFAULT NULL,
  `itmvol` char(15) DEFAULT NULL,
  `itmtype` int(11) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_item_stock
-- ----------------------------
CREATE TABLE `tbm_item_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iditm` int(11) DEFAULT NULL,
  `itmqty` int(11) DEFAULT NULL,
  `inputtype` int(11) DEFAULT NULL,
  `descinput` char(50) DEFAULT NULL,
  `dateinput` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `itmprice` decimal(10,0) DEFAULT NULL,
  `itmexpi` date DEFAULT NULL,
  `idsup` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_disc
-- ----------------------------
CREATE TABLE `tbm_m_disc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iditm` int(11) DEFAULT NULL,
  `discamt` decimal(10,0) DEFAULT NULL,
  `descdisc` int(11) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_event
-- ----------------------------
CREATE TABLE `tbm_m_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descevent` int(11) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_icon
-- ----------------------------
CREATE TABLE `tbm_m_icon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descicon` char(15) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_item
-- ----------------------------
CREATE TABLE `tbm_m_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idmenu` int(11) DEFAULT NULL,
  `deschead` char(50) DEFAULT NULL,
  `desccont` varchar(255) DEFAULT NULL,
  `idicon` int(11) DEFAULT NULL,
  `idpcs` int(11) DEFAULT NULL,
  `idqty` int(11) DEFAULT NULL,
  `idvol` int(11) DEFAULT NULL,
  `idprice` int(11) DEFAULT NULL,
  `iddisc` int(11) DEFAULT NULL,
  `idevent` int(11) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_pcs
-- ----------------------------
CREATE TABLE `tbm_m_pcs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descpcs` char(15) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_price
-- ----------------------------
CREATE TABLE `tbm_m_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iditem` int(11) DEFAULT NULL,
  `sellprice` decimal(11,0) DEFAULT NULL,
  `pricedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pricedesc` char(50) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_qty
-- ----------------------------
CREATE TABLE `tbm_m_qty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descqty` char(15) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_m_vol
-- ----------------------------
CREATE TABLE `tbm_m_vol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descvol` char(15) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_member
-- ----------------------------
CREATE TABLE `tbm_member` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `userid` char(50) DEFAULT NULL,
  `notlp` char(15) DEFAULT NULL,
  `passcode` char(15) DEFAULT NULL,
  `useremail` char(50) DEFAULT NULL,
  `userpass` char(50) DEFAULT NULL,
  `gcmcode` varchar(500) DEFAULT NULL,
  `validat` int(11) DEFAULT '0',
  `apptkn` varchar(255) DEFAULT NULL,
  `onlog` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tbm_menu
-- ----------------------------
CREATE TABLE `tbm_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` char(50) DEFAULT NULL,
  `mnuicon` char(50) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `book` VALUES ('25', 'Book B2', '17');
INSERT INTO `book` VALUES ('26', 'Book B1', '17');
INSERT INTO `book` VALUES ('27', 'Book B3', '17');
INSERT INTO `book` VALUES ('28', 'Book A3', '18');
INSERT INTO `book` VALUES ('29', 'Book A2', '18');
INSERT INTO `book` VALUES ('30', 'Book A1', '18');
INSERT INTO `book_category` VALUES ('17', 'Category B');
INSERT INTO `book_category` VALUES ('18', 'Category A');
INSERT INTO `tbm_d_order` VALUES ('804', '445', 'ORD10916012017025540', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('805', '445', 'ORD10916012017025540', '4', '1', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('806', '445', 'ORD10916012017025540', '7', '1', '3000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('807', '445', 'ORD10916012017025540', '30', '1', '5500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('808', '445', 'ORD10916012017025540', '24', '6', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('809', '446', 'ORD10916012017025943', '24', '3', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('810', '446', 'ORD10916012017025943', '32', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('811', '446', 'ORD10916012017025943', '34', '1', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('812', '447', 'ORD10916012017030347', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('813', '448', 'ORD10916012017030547', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('814', '449', 'ORD10916012017030553', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('815', '450', 'ORD10916012017030625', '2', '2', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('816', '451', 'ORD10916012017031124', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('817', '452', 'ORD10916012017031339', '6', '1', '2500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('818', '452', 'ORD10916012017031339', '4', '1', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('819', '452', 'ORD10916012017031339', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('820', '453', 'ORD10916012017031726', '16', '1', '2500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('821', '453', 'ORD10916012017031726', '29', '1', '4500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('822', '453', 'ORD10916012017031726', '24', '4', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('823', '453', 'ORD10916012017031726', '32', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('824', '454', 'ORD11417012017204136', '1', '5', '5000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('825', '454', 'ORD11417012017204136', '2', '3', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('826', '454', 'ORD11417012017204136', '6', '1', '2500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('827', '455', 'ORD13211032017231107', '1', '1', '5000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('828', '456', 'ORD13312032017001013', '1', '1', '5000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('829', '456', 'ORD13312032017001013', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('830', '457', 'ORD13312032017001056', '12', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('831', '458', 'ORD14412032017104635', '2', '1', '10000', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('832', '458', 'ORD14412032017104635', '6', '1', '2500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('833', '459', 'ORD14612032017105507', '34', '1', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('834', '460', 'ORD15512032017120304', '34', '1', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('835', '461', 'ORD15512032017120624', '16', '1', '2500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('836', '461', 'ORD15512032017120624', '34', '1', '1500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('837', '462', 'ORD15612032017143922', '30', '1', '5500', null, null, null, null);
INSERT INTO `tbm_d_order` VALUES ('838', '463', 'ORD15613032017235508', '8', '3', '4000', null, null, null, null);
INSERT INTO `tbm_h_order` VALUES ('445', '109', 'ORD10916012017025540', 'data', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 02:59:18', '2017-01-16 02:59:18', '29000', '4');
INSERT INTO `tbm_h_order` VALUES ('446', '109', 'ORD10916012017025943', 'ajah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:13:10', '2017-01-16 03:13:10', '16000', '4');
INSERT INTO `tbm_h_order` VALUES ('447', '109', 'ORD10916012017030347', 'ajah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:13:14', '2017-01-16 03:13:14', '10000', '4');
INSERT INTO `tbm_h_order` VALUES ('448', '109', 'ORD10916012017030547', 'ajah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:13:19', '2017-01-16 03:13:19', '10000', '4');
INSERT INTO `tbm_h_order` VALUES ('449', '109', 'ORD10916012017030553', 'ajah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:14:56', '2017-01-16 03:14:56', '10000', '4');
INSERT INTO `tbm_h_order` VALUES ('450', '109', 'ORD10916012017030625', 'ajah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:15:01', '2017-01-16 03:15:01', '20000', '4');
INSERT INTO `tbm_h_order` VALUES ('451', '109', 'ORD10916012017031124', 'ahah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:11:24', '2017-01-17 03:11:24', '10000', '0');
INSERT INTO `tbm_h_order` VALUES ('452', '109', 'ORD10916012017031339', 'ajh', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:15:15', '2017-01-16 03:15:15', '14000', '4');
INSERT INTO `tbm_h_order` VALUES ('453', '109', 'ORD10916012017031726', 'ahah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-16 03:17:26', '2017-01-17 03:17:26', '23000', '0');
INSERT INTO `tbm_h_order` VALUES ('454', '114', 'ORD11417012017204136', 'segera yaaa', 'aaaaaaaaaaaaa', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-01-17 21:37:42', '2017-01-17 21:37:42', '57500', '4');
INSERT INTO `tbm_h_order` VALUES ('455', '132', 'ORD13211032017231107', 'di kirim segera', 'address', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-11 23:11:07', '2017-03-12 23:11:07', '5000', '0');
INSERT INTO `tbm_h_order` VALUES ('456', '133', 'ORD13312032017001013', 'ccvv', 'dffff', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 00:10:13', '2017-03-13 00:10:13', '15000', '0');
INSERT INTO `tbm_h_order` VALUES ('457', '133', 'ORD13312032017001056', 'cvvv', 'cvbb', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 00:10:56', '2017-03-13 00:10:56', '10000', '0');
INSERT INTO `tbm_h_order` VALUES ('458', '144', 'ORD14412032017104635', 'tambah', 'detail', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 10:46:35', '2017-03-13 10:46:35', '12500', '0');
INSERT INTO `tbm_h_order` VALUES ('459', '146', 'ORD14612032017105507', 'tamvahan', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 10:55:07', '2017-03-13 10:55:07', '1500', '0');
INSERT INTO `tbm_h_order` VALUES ('460', '155', 'ORD15512032017120304', 'data', 'rest', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 12:06:15', '2017-03-12 12:06:15', '1500', '4');
INSERT INTO `tbm_h_order` VALUES ('461', '155', 'ORD15512032017120624', 'ajah', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 12:06:24', '2017-03-13 12:06:24', '4000', '0');
INSERT INTO `tbm_h_order` VALUES ('462', '156', 'ORD15612032017143922', 'di tambahkan', 'alamatsy', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-12 14:39:22', '2017-03-13 14:39:22', '5500', '0');
INSERT INTO `tbm_h_order` VALUES ('463', '156', 'ORD15613032017235508', 'fghg', 'test', '-60.89182931238000000000', '80.98787123712300000000', 'alamat test', '2017-03-13 23:55:29', '2017-03-13 23:55:29', '12000', '4');
INSERT INTO `tbm_item` VALUES ('1', '1', 'Item A 1', null, 'fa-address-book', '5000', 'pack', '250', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('2', '1', 'Item A 2', null, 'fa-address-book-o', '10000', 'pack', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('3', '1', 'Item A 3', null, 'fa-address-card', '15000', 'pack', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('4', '1', 'Item A 4', null, 'fa-address-card-o', '1500', 'litter', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('5', '1', 'Item A 5', null, 'fa-adjust', '25000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('6', '1', 'Item A 6', null, 'fa-american-sign-language-interpreting', '2500', 'litter', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('7', '1', 'Item A 7', null, 'fa-anchor', '3000', 'pack', '250', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('8', '1', 'Item A 8', null, 'fa-archive', '4000', 'pack', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('9', '1', 'Item A 9', null, 'fa-area-chart', '4500', 'pack', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('10', '1', 'Item A 10', null, 'fa-arrows', '5500', 'litter', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('11', '2', 'Item B 1', null, 'fa-assistive-listening-systems', '5000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('12', '2', 'Item B 2', null, 'fa-asterisk', '10000', 'litter', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('13', '2', 'Item B 3', null, 'fa-at', '15000', 'pack', '250', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('14', '2', 'Item B 4', null, 'fa-automobile', '1500', 'pack', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('15', '2', 'Item B 5', null, 'fa-audio-description', '25000', 'pack', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('16', '2', 'Item B 6', null, 'fa-balance-scale', '2500', 'litter', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('17', '2', 'Item B 7', null, 'fa-ban', '3000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('18', '2', 'Item B 8', null, 'fa-bank', '4000', 'litter', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('19', '2', 'Item B 9', null, 'fa-bar-chart', '4500', 'pack', '250', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('20', '1', 'Item A 20', null, 'fa-bar-chart-o', '5500', 'pack', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('21', '2', 'Item B 21', null, 'fa-barcode', '5000', 'pack', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('22', '1', 'Item A 21', null, 'fa-bars', '10000', 'litter', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('23', '2', 'Item B 22', null, 'fa-bath', '15000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('24', '1', 'Item A 22', null, 'fa-bathtub', '1500', 'litter', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('25', '2', 'Item B 23', null, 'fa-battery-0', '25000', 'pack', '250', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('26', '1', 'Item A 23', null, 'fa-bed', '2500', 'pack', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('27', '2', 'Item B 24', null, 'fa-beer', '3000', 'pack', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('28', '1', 'Item A 24', null, 'fa-bell', '4000', 'litter', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('29', '2', 'Item B 25', null, 'fa-bicycle', '4500', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('30', '1', 'Item A 25', null, 'fa-binoculars', '5500', 'litter', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('31', '2', 'Item B 26', null, 'fa-birthday-cake', '5000', 'pack', '250', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('32', '1', 'Item A 26', null, 'fa-blind', '10000', 'pack', '500', 'gr', null, '1');
INSERT INTO `tbm_item` VALUES ('33', '2', 'Item B 27', null, 'fa-briefcase', '15000', 'pack', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('34', '1', 'Item A 27', null, 'fa-bus', '1500', 'litter', '1', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('35', '2', 'Item B 28', null, 'fa-camera', '25000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('36', '2', 'Item B 29', '', 'fa-camera', '25000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item` VALUES ('37', '2', 'Item A 28', '', 'fa-camera', '25000', 'pack', '250', 'kg', null, '1');
INSERT INTO `tbm_item_stock` VALUES ('1', '1', '50', '1', 'Pembelian stock pertama', '2016-12-20 23:57:20', '250000', '2016-12-01', '1');
INSERT INTO `tbm_item_stock` VALUES ('38', null, null, null, null, null, null, null, null);
INSERT INTO `tbm_m_disc` VALUES ('1', null, null, null, null);
INSERT INTO `tbm_m_disc` VALUES ('2', null, null, null, null);
INSERT INTO `tbm_m_disc` VALUES ('3', null, null, null, null);
INSERT INTO `tbm_m_item` VALUES ('1', '1', 'Item A', null, null, '1', '1', '1', '3', null, null, '1');
INSERT INTO `tbm_m_item` VALUES ('2', '1', 'Item B', null, null, '1', '2', '1', '2', null, null, '1');
INSERT INTO `tbm_m_pcs` VALUES ('1', 'pack', '1');
INSERT INTO `tbm_m_pcs` VALUES ('2', 'litter', '1');
INSERT INTO `tbm_m_pcs` VALUES ('3', 'pcs', '1');
INSERT INTO `tbm_m_price` VALUES ('1', '1', '5000', '2016-12-19 23:29:32', null, '0');
INSERT INTO `tbm_m_price` VALUES ('2', '2', '10000', '2016-12-20 23:30:36', null, '1');
INSERT INTO `tbm_m_price` VALUES ('3', '1', '20000', '2016-12-20 23:30:41', null, '1');
INSERT INTO `tbm_member` VALUES ('156', 'shandy', '089685777475', '1932', null, 'kvEt1papzISbkRSRN4vKJg==', 'deBzA1fqd7A:APA91bH7lKOIfj38EQemJUVR5a6wqQKHKEHke0DSqsoKSwuWVVrZFC_OiZmFFn9dH14apY9mJsaAq90--1rufMtX-Z_MyM6QzWNfZPDe7QXx6KT9HAHDJkChppA_HvZzOIgJ05IRzgpB', '1', 'Odp9N6WsgleDR7mGt+pA8I+MhxPSZeZT', '1');
INSERT INTO `tbm_menu` VALUES ('1', 'Buah', 'fa-linux', '1');
INSERT INTO `tbm_menu` VALUES ('2', 'Daging', 'fa-weixin', '1');
INSERT INTO `tbm_menu` VALUES ('3', 'Menu 3', 'fa-group', '1');
INSERT INTO `tbm_menu` VALUES ('4', 'Menu 4', 'fa-shopping-cart', '1');
INSERT INTO `tbm_menu` VALUES ('5', 'Menu 5', 'fa-linux', '1');
INSERT INTO `tbm_menu` VALUES ('6', 'Menu 5', 'fa-shopping-cart', '1');
