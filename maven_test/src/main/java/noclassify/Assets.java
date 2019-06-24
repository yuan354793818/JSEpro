/**
 * Copyright (c) 2015, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package noclassify;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
public class Assets implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_CODE = "code";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_EN_NAME = "en_name";
	public static final String FIELD_ASSETS_CODE_PARENT = "assets_code_parent";
	public static final String FIELD_MODEL = "model";
	public static final String FIELD_SPEC = "spec";
	public static final String FIELD_ASSETS_SORT_CODE = "assets_sort_code";
	public static final String FIELD_ASSETS_SORT_GB_CODE = "assets_sort_gb_code";
	public static final String FIELD_ASSETS_SORT_GB_NAME = "assets_sort_gb_name";
	public static final String FIELD_SOURCE = "source";
	public static final String FIELD_BASE_DEP_CODE = "base_dep_code";
	public static final String FIELD_BASE_DEP_NAME = "base_dep_name";
	public static final String FIELD_COUNTRY = "country";
	public static final String FIELD_DIRECTION = "direction";
	public static final String FIELD_BASE_TEACHER_NO_KEEPER = "base_teacher_no_keeper";
	public static final String FIELD_KEEPER_NAME = "keeper_name";
	public static final String FIELD_BASE_ROOM_ID = "base_room_id";
	public static final String FIELD_BASE_ROOM_NAME = "base_room_name";
	public static final String FIELD_PURCHASER = "purchaser";
	public static final String FIELD_PRICE = "price";
	public static final String FIELD_PRICE_DOLLAR = "price_dollar";
	public static final String FIELD_PRODUCER = "producer";
	public static final String FIELD_PURCHASE_DATE = "purchase_date";
	public static final String FIELD_OUTLAY_SUBJECT = "outlay_subject";
	public static final String FIELD_STOCK_DATE = "stock_date";
	public static final String FIELD_ASSESSOR = "assessor";
	public static final String FIELD_MANAGE_LEVEL = "manage_level";
	public static final String FIELD_DEPRESIATION_METHOD = "depresiation_method";
	public static final String FIELD_SR_NO = "sr_no";
	public static final String FIELD_BILL_NO = "bill_no";
	public static final String FIELD_PROVIDER = "provider";
	public static final String FIELD_SERVICE_DATE = "service_date";
	public static final String FIELD_FACTORY_DATE = "factory_date";
	public static final String FIELD_FACTORY_NO = "factory_no";
	public static final String FIELD_STATE = "state";
	public static final String FIELD_CHECK_CYCLE = "check_cycle";
	public static final String FIELD_CHECKER = "checker";
	public static final String FIELD_LAST_CHECK_DATE = "last_check_date";
	public static final String FIELD_FINANCE_DATE = "finance_date";
	public static final String FIELD_FINANCE_ASSESSOR = "finance_assessor";
	public static final String FIELD_FINANCE_BILL = "finance_bill";
	public static final String FIELD_FINANCE_BILL_PRICECHANGE = "finance_bill_pricechange";
	public static final String FIELD_FINANCE_STATE = "finance_state";
	public static final String FIELD_MODIFIER = "modifier";
	public static final String FIELD_MODIFY_TIME = "modify_time";
	public static final String FIELD_TEMP1 = "temp1";
	public static final String FIELD_TEMP2 = "temp2";
	public static final String FIELD_TEMP3 = "temp3";
	public static final String FIELD_TEMP4 = "temp4";
	public static final String FIELD_TEMP5 = "temp5";
	public static final String FIELD_CHECK_METHOD = "check_method";

	public static final String FIELD_OUTLAY_CARD_NO = "outlay_card_no";
	public static final String FIELD_OUTLAY_PRINCIPAL_NO = "outlay_principal_no";
	public static final String FIELD_OUTLAY_PRINCIPAL_NAME = "outlay_principal_name";

	public static final String FIELD_PRINCIPLE = "principle";
	public static final String FIELD_TRAFFIC_CHARGE = "traffic_charge";
	public static final String FIELD_LATE_FEE = "late_fee";
	public static final String FIELD_OTHER_INFO = "other_info";
	public static final String FIELD_REMARK = "remark";
	public static final String FIELD_CHECK_AND_ACCEPT = "check_and_accept";
	public static final String FIELD_NO_FOR_BH = "no_for_bh";
	public static final String FIELD_INPUT_CODE = "input_code";
	public static final String FIELD_SHOP_MAN = "shop_man";
	public static final String FIELD_ASSETS_PRODUCER_CODE = "assets_producer_code";
	public static final String FIELD_SHOP_SUPPLIER_NO = "shop_supplier_no";
	public static final String FIELD_CAN_FLITTING = "can_flitting";
	public static final String FIELD_TECHNICAL_TARGET = "technical_target";
	public static final String FIELD_ACCOMPANY_INFO = "accompany_info";
	public static final String FIELD_ACCESSORIES_NAME = "accessories_name";
	public static final String FIELD_INVOICE_NO = "invoice_no";
	public static final String FIELD_ATTACH_NUM = "attach_num";
	public static final String FIELD_ATTACH_PRICE = "attach_price";
	public static final String FIELD_ASSETS_SORT_NAME = "assets_sort_name";
	public static final String FIELD_DEFAULT_CHECK_CYCLE = "default_check_cycle";
	public static final String FIELD_BELONG = "belong";
	public static final String FIELD_SH_BARGAIN_NO = "sh_bargain_no";
	public static final String FIELD_FINANCE_BASE_TEACHER_NO = "finance_base_teacher_no";
	public static final String FIELD_FINANCE_DATA = "finance_data";
	public static final String FIELD_PRICE_FOREIGN_TYPE = "price_foreign_type";
	public static final String FIELD_LAB_TELEPHONE = "lab_telephone";
	public static final String FIELD_LARGE_TECH_PARAM = "large_tech_param";
	public static final String FIELD_LARGE_DESCRIPTION = "large_description";
	public static final String FIELD_LARGE_SERVICE_AREA = "large_service_area";
	public static final String FIELD_LARGE_MAIN_FUNCTION = "large_main_function";
	public static final String FIELD_LARGE_DEMONSTRATE_CODE = "large_demonstrate_code";
	public static final String FIELD_TYPE = "type";
	public static final String FIELD_UNIT = "unit";
	public static final String FIELD_NUM = "num";
	public static final String FIELD_ZJZT = "zjzt";
	public static final String FIELD_ZJFF = "zjff";
	public static final String FIELD_ZJYSX = "zjysx";
	public static final String FIELD_YZJYS = "yzjys";
	public static final String FIELD_ZJCZL = "zjczl";
	public static final String FIELD_OUTLAY_SUBJECT_NAME = "outlay_subject_name";
	public static final String FIELD_CONFIRM_STATE = "confirm_state";
	public static final String FIELD_SUB_TYPE = "sub_type";
	public static final String FIELD_CONFIRM_REJECT = "confirm_reject";
	public static final String FIELD_IMAGE_LIST = "image_list";
	public static final String FIELD_FILE_LIST = "file_list";
	public static final String FIELD_FURNITURE_BATCH_CODE = "furniture_batch_code";
	public static final String FIELD_IS_IMPORT = "is_import";
	public static final String FIELD_AGENT_FEE = "agent_fee";
	public static final String FIELD_CGZZXS = "cgzzxs";
	public static final String FIELD_CAIZXJFLY = "caizxjfly";
	public static final String FIELD_QITJFLY = "qitjfly";
	public static final String FIELD_DISPDATE = "dispdate";
	public static final String FIELD_CHANQXS = "chanqxs";
	public static final String FIELD_CHEJH = "chejh";
	public static final String FIELD_CHEPH = "cheph";
	public static final String FIELD_FADJH = "fadjh";
	public static final String FIELD_PAIQL = "paiql";
	public static final String FIELD_BIANZQK = "bianzqk";
	public static final String FIELD_YONGTFL = "yongtfl";
	public static final String FIELD_QUANSXZ = "quansxz";
	public static final String FIELD_QUANSZM = "quanszm";
	public static final String FIELD_QUANSZH = "quanszh";
	public static final String FIELD_FAZSJ = "fazsj";
	public static final String FIELD_GUOZWJL = "guozwjl";
	public static final String FIELD_ZIYMJ = "ziymj";
	public static final String FIELD_CHUJMJ = "chujmj";
	public static final String FIELD_CHUZMJ = "chuzmj";
	public static final String FIELD_QITMJ = "qitmj";
	public static final String FIELD_ZUOLWZ = "zuolwz";
	public static final String FIELD_TUDMJ = "tudmj";
	public static final String FIELD_TUDZZMMJ = "tudzzmmj";
	public static final String FIELD_DIH = "dih";
	public static final String FIELD_JIANZJG = "jianzjg";
	public static final String FIELD_JIANZMJ = "jianzmj";
	public static final String FIELD_SHIYMJ = "shiymj";
	public static final String FIELD_DIAXMJ = "diaxmj";
	public static final String FIELD_HUIYSMJ = "huiysmj";
	public static final String FIELD_CHEKMJ = "chekmj";
	public static final String FIELD_SHITMJ = "shitmj";
	public static final String FIELD_PEIDSMJ = "peidsmj";
	public static final String FIELD_JIFMJ = "jifmj";
	public static final String FIELD_BANGSMJ = "bangsmj";
	public static final String FIELD_WENWDJ = "wenwdj";
	public static final String FIELD_GUANLDW = "guanldw";
	public static final String FIELD_ZHUCDJJG = "zhucdjjg";
	public static final String FIELD_ZHUCDJSJ = "zhucdjsj";
	public static final String FIELD_ZHUANLH = "zhuanlh";
	public static final String FIELD_PIZWH = "pizwh";
	public static final String FIELD_CHELCD = "chelcd";
	public static final String FIELD_ZUOWS = "zuows";
	public static final String FIELD_DISPID = "dispid";
	public static final String FIELD_FINANCE_SORT = "finance_sort";
	public static final String FIELD_GZ_CATEGORY = "gz_category";
	public static final String FIELD_JYB_CATEGORY = "jyb_category";
	public static final String FIELD_STOCK_PRICE = "stock_price";
	public static final String FIELD_GG_CODE = "gg_code";
	public static final String FIELD_FT_BARGAIN_NO = "ft_bargain_no";
	public static final String FIELD_IS_CAR = "is_car";
	public static final String FIELD_REQUEST_BPM_NO = "request_bpm_no";
	public static final String FIELD_CHELX = "chelx";
	public static final String FIELD_JUNGRQ = "jungrq";
	public static final String FIELD_DANGAH = "dangah";
	public static final String FIELD_CANGPND = "cangpnd";
	public static final String FIELD_BAOCNX = "baocnx";
	public static final String FIELD_CHUBRQ = "chubrq";
	public static final String FIELD_CHUSZZNF = "chuszznf";
	public static final String FIELD_YUJSMZL = "yujsmzl";
	public static final String FIELD_GANGSK = "gangsk";
	public static final String FIELD_FAMR = "famr";
	public static final String FIELD_ZHENGSH = "zhengsh";
	public static final String FIELD_FAMMC = "fammc";
	public static final String FIELD_DILYT = "dilyt";
	public static final String FIELD_SHEBYTID = "shebytid";
	public static final String FIELD_CHELXSZSYR = "chelxszsyr";
	public static final String FIELD_JINGZ = "jingz";
	public static final String FIELD_LEIJZJ = "leijzj";
	public static final String FIELD_JIAZLX = "jiazlx";
	public static final String FIELD_DIXMJ = "dixmj";
	public static final String FIELD_GOUZHUWJL = "gouzhuwjl";
	public static final String FIELD_IMPORT_MS_NO = "import_ms_no";
	public static final String FIELD_IS_IN_PROC_EQU = "is_in_proc_equ";
	public static final String FIELD_IN_PROC_EQU_ID = "in_proc_equ_id";
	public static final String FIELD_BOOK_PRICE = "book_price";
	public static final String FIELD_PRICE_TYPE = "price_type";
	public static final String FIELD_ASSESS_COMPANY = "assess_company";
	public static final String FIELD_ASSESS_NAME = "assess_name";
	public static final String FIELD_BRAND = "brand";
	public static final String FIELD_ZIYJZ = "ziyjz";
	public static final String FIELD_CHUJJZ = "chujjz";
	public static final String FIELD_CHUZJZ = "chuzjz";
	public static final String FIELD_QITJZ = "qitjz";
	public static final String FIELD_DUIWTZJZ = "duiwtzjz";
	public static final String FIELD_DUIWTZMJ = "duiwtzmj";
	public static final String FIELD_XCFS = "xcfs";
	public static final String FIELD_FENTMJ = "fentmj";
	public static final String FIELD_DUYMJ = "duymj";
	public static final String FIELD_TUDSYQLX = "tudsyqlx";
	public static final String FIELD_TEMP_DATE = "temp_date";
	public static final String FIELD_BUDGET_PROJECT_NO = "budget_project_no";
	public static final String FIELD_SHOUYNX = "shouynx";
	public static final String FIELD_USE_DATE = "use_date";
	public static final String FIELD_APPLICATION_DATE = "application_date";
	public static final String FIELD_BOOK_NUM = "book_num";
	public static final String FIELD_BOOK_TYPES = "book_types";
	public static final String FIELD_FORMED_METHOD = "formed_method";
	public static final String FIELD_IMPORT_CD = "import_cd";
	public static final String FIELD_IMPORT_PORT = "import_port";
	public static final String FIELD_IMPORT_CUSTOMS = "import_customs";
	public static final String FIELD_IMPORT_DATE = "import_date";
	public static final String FIELD_IS_SHARE = "is_share";
	public static final String FIELD_IS_CHARGE_STANDARD = "is_charge_standard";
	public static final String FIELD_HS_NO = "hs_no";
	public static final String FIELD_MANAGER_REMARK = "manager_remark";
	public static final String FIELD_JIANZDW = "jianzdw";
	public static final String FIELD_DROP_BPM_NO = "drop_bpm_no";
	public static final String FIELD_TEMP6 = "temp6";
	public static final String FIELD_TEMP7 = "temp7";
	public static final String FIELD_TEMP8 = "temp8";
	public static final String FIELD_TEMP9 = "temp9";
	public static final String FIELD_TEMP10 = "temp10";
	public static final String FIELD_ASSETS_USER = "assets_user";
	public static final String FIELD_REMARK_MINE = "remark_mine";
	public static final String FIELD_REMARK_MANAGER = "remark_manager";
	public static final String FIELD_REMARK_DIVISION = "remark_division";
	public static final String FIELD_RFID = "rfid";
	public static final String FIELD_CAMPUS = "campus";
	public static final String FIELD_DISCS = "discs";
	public static final String FIELD_DIXCS = "dixcs";
	public static final String FIELD_CHECK_USE_STATE = "check_use_state";

	public static final String FIELD_IS_OPEN_SHARE = "is_open_share";
	public static final String FIELD_TECHNICAL_PROVIDER = "technical_provider";
	public static final String FIELD_CUSTOMS_SUPERVISION_SITUATION = "customs_supervision_situation";
	public static final String FIELD_CUSTOMS_DUTY = "customs_duty";
	public static final String FIELD_SECURITY_TYPE = "security_type";
	public static final String FIELD_DONORS = "donors";

	public static final String FIELD_ASSETS_BOOKS_SORT_CODE = "assets_books_sort_code";
	public static final String FIELD_ASSETS_BOOKS_SORT_NAME = "assets_books_sort_name";

	public static final String FIELD_CLASSIFIED = "classified";
	public static final String FIELD_AUTHORIZATION_NUM = "authorization_num";
	public static final String FIELD_AUTHORIZATION_YEAR = "authorization_year";
	public static final String FIELD_WORK_RATE = "work_rate";
	public static final String FIELD_ACCEPTANCE_DATE = "acceptance_date";
	public static final String FIELD_IS_SPECIAL = "is_special";

	public static final String FIELD_REGISTER_NO = "register_no";
	public static final String FIELD_FULL_NAME = "full_name";
	public static final String FIELD_SHORT_NAME = "short_name";
	public static final String FIELD_VALIDITY_PERIOD = "validity_period";
	public static final String FIELD_USE = "use";
	public static final String FIELD_DOMAIN_TYPE = "domain_type";
	public static final String FIELD_EMAIL = "email";

	public static final String FIELD_ACCESS_TYPE = "access_type";
	public static final String FIELD_SUBSCRIBE_TYPE = "subscribe_type";
	public static final String FIELD_DB_SORT_ID_SECOND = "db_sort_id_second";
	public static final String FIELD_ISBN = "isbn";
	public static final String FIELD_ISSN = "issn";
	public static final String FIELD_EISSN = "eissn";
	public static final String FIELD_AUTHOR = "author";
	public static final String FIELD_PUBLISHER = "publisher";
	public static final String FIELD_PUBLISH_YEAR = "publish_year";
	public static final String FIELD_YEAR_START = "year_start";
	public static final String FIELD_YEAR_END = "year_end";
	public static final String FIELD_BAR_CODE = "bar_code";
	public static final String FIELD_EXPIRY_DATE = "expiry_date";
	public static final String FIELD_CHELNYX = "chelnyx";
	public static final String FIELS_IS_STUDENT_FURNITURE = "is_student_furniture";

	private String code; /* 资产编号 */
	private String name; /* 资产名称 */
	private String enName; /* 外语名称 */
	private String assetsCodeParent; /* 存储附件设备对应主件设备编号， 若为主件设备，则此处为空 */
	private String model; /* 型号 */
	private String spec; /* 规格 */
	private String assetsSortCode; /* 十六大类分类号 */
	private String source; /* 资产来源 公共代码库 */
	private String baseDepCode; /* 领用单位编码 */
	private String baseDepName; /* 领用单位名称 备用字段，方便导入 */
	private String country; /* 国别码 公共代码库 */
	private String direction; /* 使用方向 公共代码库 */
	private String baseTeacherNoKeeper; /* 领用人编号 教师编号 */
	private String keeperName; /* 领用人姓名 备用字段，方便导入 */
	private Long baseRoomId; /* 存放房间编号 */
	private String baseRoomName; /* 存放房间名称 备用字段，方便导入 */
	private String purchaser; /* 经手人 */
	private BigDecimal price; /* 单价 */
	private BigDecimal priceDollar; /* 外币价格 */
	private String producer; /* 厂家,图书出版社 */
	private Date purchaseDate; /* 购买日期 */
	private Date stockDate; /* 入库日期 */
	private String assessor; /* 记账人 */
	private String manageLevel; /* 管理级别 公共代码库 */
	private String depresiationMethod; /* 折旧方式 公共代码库 */
	private String srNo; /* 科研号 */
	private String billNo; /* 单据号 */
	private String provider; /* 供货商 */
	private Date serviceDate; /* 保修期限 */
	private Date factoryDate; /* 出厂日期 */
	private String factoryNo; /* 出厂号 */
	private Float state; /* 现状 */
	private Long checkCycle = 12L; /* 实际清查周期 单位月份 3,6,12,18,24 */
	private String checker; /* 清查人 */
	private Date lastCheckDate; /* 最后一次清查时间 */
	private Date financeDate; /* 财务审核日期 财务入账日期 */
	private String financeAssessor; /* 财务审核人 */
	private String financeBill; /* 财务审核单据 会计凭证号 */
	private String financeBillPricechange; /* 财务审核单据 会计凭证号 (价值增减) */
	private String financeState; /* 0未入账1已入账 财务入账状态 */
	private String modifier; /* 最后修改人 */
	private Date modifyTime; /* 最后修改时间 */
	private String temp1; /* 备用1-用作领用人自己管理使用 */
	private String temp2; /* 备用2-用作单位资产管理员管理使用 */
	private String temp3; /* 备用3-用途 */
	private String temp4; /* 备用4-用作保存建账申请编号 */
	private String temp5; /* 备用5 主要功能 */
	private String checkMethod; /* ***清查方式 公共代码库 1自查 2 现场核查 3网络核查 */
	private String principle; /* 负责人姓名 */
	private BigDecimal trafficCharge; /* 运输费 */
	private BigDecimal lateFee; /* 滞纳金 */
	private String otherInfo; /* 其他杂项 */
	private String remark; /* 备注 */
	private String checkAndAccept; /* 验收人姓名 */
	private String inputCode; /* 输入码 */
	private String shopMan; /* 采购人姓名 */
	private String assetsProducerCode; /* 厂家代码 */
	private String shopSupplierNo; /* 供货商编号 */
	private Long canFlitting; /* 是否可调拨 */
	private String technicalTarget; /* 技术指标 */
	private String accompanyInfo; /* 随附资料清单 */
	private String accessoriesName; /* 附件名称 */
	private String invoiceNo; /* 发票号 */
	private Long attachNum; /* 附件个数 */
	private BigDecimal attachPrice; /* 附件价格 */
	private String assetsSortName; /* 分类名称 */
	private Long defaultCheckCycle = 12L; /* 默认核查周期 */
	private String belong; /* 资产归属 数据字典 1学校资产 2医院资产 3后勤资产 */
	private String shBargainNo; /* 合同号 */
	private String financeBaseTeacherNo; /* 财务报账人 */
	private String financeData; /* 财务报账原始返回数据 */
	private String priceForeignType; /* 外币类型 */
	private String labTelephone; /* 贵重-实验室电话 */
	private String largeTechParam; /* 贵重-技术指标 */
	private String largeDescription; /* 贵重-描述 */
	private String largeServiceArea; /* 贵重-服务领域 */
	private String largeMainFunction; /* 贵重-主要功能 */
	private String largeDemonstrateCode; /* 贵重-论证编号 */
	private String type; /* 资产类别 */
	private String unit; /* 计量单位 */
	private Long num; /* 资产数量 */
	private String zjzt; /* 折旧状态 */
	private String zjff; /* 折旧方法 */
	private Long zjysx; /* 折旧月数限 */
	private Long yzjys; /* 已折旧月数 */
	private Long zjczl; /* 折旧残值率 */
	private Long confirmState; /* 认领状态 0 未认领 1已认领 -1退回 默认1方便建账 */
	private String subType; /* 资产子类编码 */
	private String confirmReject; /* 认领退回理由 */
	private String imageList; /* 图片列表 */
	private String fileList; /* 文件附件列表 */
	private String furnitureBatchCode; /*  */
	private Long isImport; /* 0,内贸1,进口免税2进口征税 */
	private BigDecimal agentFee; /*  */
	private String cgzzxs; /* 采购组织形式 数据字典 */
	private BigDecimal caizxjfly; /* 财政拨款 财政拨款+其他资金 = 实际价值 */
	private BigDecimal qitjfly; /* 其他资金 财政拨款+其他资金 = 实际价值 */
	private Date dispdate; /* 处置日期 */
	private String chanqxs; /* 土地、房屋、图书文物及陈列品 产权形式 数据字典 */
	private String chejh; /* 车辆 车架号 */
	private String cheph; /* 车辆 车牌号 */
	private String fadjh; /* 车辆 发动机号 */
	private String paiql; /* 车辆 排气量 */
	private String bianzqk; /* 车辆 编制情况 数据字典 */
	private String yongtfl; /* 车辆 用途分类 数据字典、房屋、构筑物 */
	private String wenwdj; /* 文物 文物等级 数据字典 */
	private String guanldw; /* 无形资产 管理单位(机构) */
	private String zhucdjjg; /* 无形资产 注册登记机关 */
	private Date zhucdjsj; /* 无形资产 注册登记时间/汽车 */
	private String zhuanlh; /* 无形资产 专利号 */
	private String pizwh; /* 无形资产 批准文号 */
	private String chelcd; /* 车辆 产地 数据字典 */
	private Long zuows; /* 车辆 座位数 */
	private Long dispid; /* 处置编号：下账处置id */
	private String financeSort; /* 财务六大类 */
	private String gzCategory; /* 国资11大类 */
	private String jybCategory; /* 教育部处置10大类 */
	private BigDecimal stockPrice; /* 用于存储入库时资产价格，除建账修订外其他业务都不修改此字段 */
	private String ggCode; /* 国管局类别代码（新10类） */
	private String ftBargainNo; /* 外贸合同号 */
	private Long isCar; /* 是否汽车1、汽车 0、不是汽车 */
	private String requestBpmNo; /* 建账业务号 */
	private String chelx; /* 车辆 类型 数据字典 */
	private String dangah; /* 档案号 文物陈列品 */
	private String cangpnd; /* 藏品年代 */
	private String baocnx; /* 保存年限 */
	private String chubrq; /* 出版日期 */
	private Long chuszznf; /* 出生/载种年份 */
	private BigDecimal yujsmzl; /* 预计使用年限/寿命/种龄 */
	private String gangsk; /* 纲属科 */
	private String famr; /* 发明人 */
	private String zhengsh; /* 证书号 */
	private String fammc; /* 发明名称 */
	private String shebytid; /* 设备用途 */
	private String chelxszsyr; /* 车辆行驶证所有人 */
	private BigDecimal jingz; /* 净值 */
	private BigDecimal leijzj; /* 累计折旧 */
	private String jiazlx = "01"; /* 价值类型 无价值 重置值 原值 暂估值 评估值 */
	private String importMsNo; /* 征免税号 */
	private Long isInProcEqu; /* 是否从在建工程申请建账入库的设备 */
	private Long inProcEquId; /* 在建工程编号 */
	private BigDecimal bookPrice; /* 图书码洋 */
	private Long priceType; /* 捐赠资产价值类型：0、待评估，1、原始价值，2、评估价值 */
	private String assessCompany; /* 捐赠资产评估公司名称 */
	private String assessName; /* 捐赠资产评估人姓名 */
	private String brand; /* 品牌 */
	private String xcfs; /* 软件形成方式 */
	private Date tempDate; /* 无形资产授权公告日 */
	private String budgetProjectNo; /* 预算项目编号 */
	private Long shouynx; /* 无形资产收益年限(月) */
	private Date useDate; /* 投入使用日期 */
	private Date applicationDate; /* 商标申请日期 */
	private Long bookNum; /* 图书册书 */
	private Long bookTypes; /* 图书种数 */
	private Long formedMethod; /* 软件形成方式（数据字典） */
	private String importCd; /* 进口报关单编号 */
	private String importPort; /* 进口口岸 */
	private String importCustoms; /* 主管海关 */
	private Date importDate; /* 进口日期 */
	private Long isShare; /* 申报共享标志 1、已设备共享 0未设备共享 */
	private Long isChargeStandard; /* 收费标准已评议标志*必填项，收费标准已经校内收费认定权威机构审核认定的填写1，未评议填写0 */
	private String hsNo; /* HS编码（税号）*必填项，按征免税证明表填写 */
	private String managerRemark; /* 后续管理记录仪器的后续管理记录信息 */
	private Long dropBpmNo; /* 下账业务号 */
	private String temp6; /* 客户自定义字段 */
	private String temp7; /* 客户自定义字段 */
	private String temp8; /* 客户自定义字段 */
	private String temp9; /* 客户自定义字段 */
	private String temp10; /* 客户自定义字段 */
	private String assetsUser; /* 资产使用人 */
	private String remarkMine; /* 普通老师备注字段 */
	private String remarkManager; /* 单位管理员备注字段 */
	private String remarkDivision; /* 主管部门备注字段 */
	private String rfid; /* 电子标签id */
	private String campus; /* 所在校区 */
	private String checkState;/* 核查状态 */
	private String invoiceImageList;/* 发票图片 */
	private String checkResult;
	private String contractImageList; /* 合同图片 */
	private String checkUseState;
	private String assetsSortGbCode; /* 国标分类 */
	private String assetsSortGbName; /* 国标分类名称 */
	private Long isOpenShare;/* 是否开放共享 */
	private String technicalProvider;/* 技术服务协议供货商 */
	private Long customsSupervisionSituation;/* 海关监管情况 */
	private BigDecimal customsDuty; /* 海关关税 */
	private Long securityType;/* 仪器设备安全类型 */
	private String donors;/* 捐赠方 */
	private String baseTeacherNameKeeper; /* 领用人姓名 */
	private String typeName; /* 资产类别名称 */
	private String assetsBooksSortCode; /* 图书分类号 */
	private String assetsBooksSortName; /* 图书分类名称 */
	private Integer pages;// 页数
	private String tags;// 图书标签
	private String translator;// 译者
	private String subtitle;// 小标题
	private String binding;// 装订
	private Integer classified;// 是否涉密
	private Integer authorizationNum;// 软件 授权许可数量
	private Integer authorizationYear;// 软件 授权许可年限
	private String imageTemp1;
	private String imageTemp2;
	private String imageTemp3;
	private Double workRate;// 2017/1/11 上午9:57:47 功率(瓦)
	private String subjectArea; // 仪器设备学科领域
	private String useGoods; // 核定使用商品
	private String interClassificGoods; // 商标国际分类
	private Date expiryDate; // 商标注册有效期限
	private Date acceptanceDate; // 验收日期
	private Long isSpecial;// 是否特种设备
	private String registerNo;// 商标注册号
	private String fullName;
	private String shortName;
	private Integer validityPeriod; // 有效期
	private String use; // 计划用途
	private Integer domainType; // 域名级别
	private BigDecimal disposalSalePrice;// 处置变卖金额
	private String platform; // 所属平台
	private String baseCode; // 基地代码
	private String assetsSortKjCode; // 科技部分类代码
	private String atArea; // 应用技术领域
	private String secretDeadline; // 涉密期限
	private String linkmanNo; // 联系人
	private String email; // 贵重-邮箱
	private String assetsSortGgjCode; /* 国标分类 */
	private String assetsSortGgjName; /* 国标分类名称 */
	private String accessType;// (电子资源)访问方式
	private String subscribeType;// (电子资源)是否新订. 1: 新订; 2: 续订;
	private Long dbSortIdSecond;// (电子资源)数据库管理模块二级目录ID
	private String isbn;// (电子资源)ISBN
	private String issn;// (电子资源)ISSN
	private String eissn;// (电子资源)EISSN
	private String author;// (电子资源)作者
	private String publisher;// (电子资源)出版商
	private Long publishYear;// (电子资源)出版年
	private Long yearStart;// (电子资源)期刊起始年
	private Long yearEnd;// (电子资源)期刊截至年

	private String outlayCardNo; /* 经费卡号 */
	private String outlayCardName; /* 经费名称 */
	private String outlaySubject; /*经费科目*/
	private String outlaySubjectName; /* 经费科目名称 */
	private String outlayPrincipalNo;/*经费负责人编号*/
	private String outlayPrincipalName;/*经费负责人名称*/
	private String outlayBaseDepCode; /*经费所属单位编号*/
	private String outlayBaseDepName; /*经费所属单位名称*/

	private String barCode; // (图书)条码号
	private Integer depreciationMonth; //资产可折旧月数
	private String chelnyx; /* 车辆能源 类型 数据字典 */
	private Long isStudentFurniture; /*是(1)否(0)学生用家具*/
	
	public Long getIsStudentFurniture() {
		return isStudentFurniture;
	}

	public void setIsStudentFurniture(Long isStudentFurniture) {
		this.isStudentFurniture = isStudentFurniture;
	}

	public String getChelnyx() {
		return chelnyx;
	}

	public void setChelnyx(String chelnyx) {
		this.chelnyx = chelnyx;
	}

	public Integer getDepreciationMonth() {
		return depreciationMonth;
	}

	public void setDepreciationMonth(Integer depreciationMonth) {
		this.depreciationMonth = depreciationMonth;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getOutlayPrincipalNo() {
		return outlayPrincipalNo;
	}

	public void setOutlayPrincipalNo(String outlayPrincipalNo) {
		this.outlayPrincipalNo = outlayPrincipalNo;
	}

	public String getOutlayPrincipalName() {
		return outlayPrincipalName;
	}

	public void setOutlayPrincipalName(String outlayPrincipalName) {
		this.outlayPrincipalName = outlayPrincipalName;
	}

	/**
	 * @return the assetsSortGgjCode
	 */
	public String getAssetsSortGgjCode() {
		return assetsSortGgjCode;
	}

	/**
	 * @param assetsSortGgjCode
	 *            the assetsSortGgjCode to set
	 */
	public void setAssetsSortGgjCode(String assetsSortGgjCode) {
		this.assetsSortGgjCode = assetsSortGgjCode;
	}

	/**
	 * @return the assetsSortGgjName
	 */
	public String getAssetsSortGgjName() {
		return assetsSortGgjName;
	}

	/**
	 * @param assetsSortGgjName
	 *            the assetsSortGgjName to set
	 */
	public void setAssetsSortGgjName(String assetsSortGgjName) {
		this.assetsSortGgjName = assetsSortGgjName;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the baseCode
	 */
	public String getBaseCode() {
		return baseCode;
	}

	/**
	 * @param baseCode
	 *            the baseCode to set
	 */
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}

	/**
	 * @return the assetsSortKjCode
	 */
	public String getAssetsSortKjCode() {
		return assetsSortKjCode;
	}

	/**
	 * @param assetsSortKjCode
	 *            the assetsSortKjCode to set
	 */
	public void setAssetsSortKjCode(String assetsSortKjCode) {
		this.assetsSortKjCode = assetsSortKjCode;
	}

	/**
	 * @return the atArea
	 */
	public String getAtArea() {
		return atArea;
	}

	/**
	 * @param atArea
	 *            the atArea to set
	 */
	public void setAtArea(String atArea) {
		this.atArea = atArea;
	}

	/**
	 * @return the secretDeadline
	 */
	public String getSecretDeadline() {
		return secretDeadline;
	}

	/**
	 * @param secretDeadline
	 *            the secretDeadline to set
	 */
	public void setSecretDeadline(String secretDeadline) {
		this.secretDeadline = secretDeadline;
	}

	/**
	 * @return the linkManNo
	 */
	public String getLinkmanNo() {
		return linkmanNo;
	}

	/**
	 * @param linkManNo
	 *            the linkManNo to set
	 */
	public void setLinkmanNo(String linkManNo) {
		this.linkmanNo = linkManNo;
	}

	/**
	 * @return the domainType
	 */
	public Integer getDomainType() {
		return domainType;
	}

	/**
	 * @param domainType
	 *            the domainType to set
	 */
	public void setDomainType(Integer domainType) {
		this.domainType = domainType;
	}

	/**
	 * @return the use
	 */
	public String getUse() {
		return use;
	}

	/**
	 * @param use
	 *            the use to set
	 */
	public void setUse(String use) {
		this.use = use;
	}

	/**
	 * @return the validityPeriod
	 */
	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	/**
	 * @param validityPeriod
	 *            the validityPeriod to set
	 */
	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	/**
	 * @return the registerNo
	 */
	public String getRegisterNo() {
		return registerNo;
	}

	/**
	 * @param registerNo
	 *            the registerNo to set
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the useGoods
	 */
	public String getUseGoods() {
		return useGoods;
	}

	/**
	 * @param useGoods
	 *            the useGoods to set
	 */
	public void setUseGoods(String useGoods) {
		this.useGoods = useGoods;
	}

	/**
	 * @return the interClassificGoods
	 */
	public String getInterClassificGoods() {
		return interClassificGoods;
	}

	/**
	 * @param interClassificGoods
	 *            the interClassificGoods to set
	 */
	public void setInterClassificGoods(String interClassificGoods) {
		this.interClassificGoods = interClassificGoods;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the subjectArea
	 */
	public String getSubjectArea() {
		return subjectArea;
	}

	/**
	 * @param subjectArea
	 *            the subjectArea to set
	 */
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}

	/**
	 * @return the pages
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the translator
	 */
	public String getTranslator() {
		return translator;
	}

	/**
	 * @param translator
	 *            the translator to set
	 */
	public void setTranslator(String translator) {
		this.translator = translator;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle
	 *            the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the binding
	 */
	public String getBinding() {
		return binding;
	}

	/**
	 * @param binding
	 *            the binding to set
	 */
	public void setBinding(String binding) {
		this.binding = binding;
	}



	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param baseTeacherNameKeeper
	 *            the baseTeacherNameKeeper to set
	 */
	public void setBaseTeacherNameKeeper(String baseTeacherNameKeeper) {
		this.baseTeacherNameKeeper = baseTeacherNameKeeper;
	}

	/**
	 * @param typeName
	 *            the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the assetsSortGbName
	 */
	public String getAssetsSortGbName() {
		return assetsSortGbName;
	}

	/**
	 * @param assetsSortGbName
	 *            the assetsSortGbName to set
	 */
	public void setAssetsSortGbName(String assetsSortGbName) {
		this.assetsSortGbName = assetsSortGbName;
	}

	/**
	 * @return the assetsSortGbCode
	 */
	public String getAssetsSortGbCode() {
		return assetsSortGbCode;
	}

	/**
	 * @param assetsSortGbCode
	 *            the assetsSortGbCode to set
	 */
	public void setAssetsSortGbCode(String assetsSortGbCode) {
		this.assetsSortGbCode = assetsSortGbCode;
	}

	/**
	 * @return the contraceImageList
	 */
	public String getContractImageList() {
		return contractImageList;
	}

	/**
	 * @param contraceImageList
	 *            the contraceImageList to set
	 */
	public void setContractImageList(String contractImageList) {
		this.contractImageList = contractImageList;
	}

	/**
	 * @return the checkResult
	 */
	public String getCheckResult() {
		return checkResult;
	}

	/**
	 * @param checkResult
	 *            the checkResult to set
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	/**
	 * @return the checkState
	 */
	public String getCheckState() {
		return checkState;
	}

	/**
	 * @param checkState
	 *            the checkState to set
	 */
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setAssetsCodeParent(String assetsCodeParent) {
		this.assetsCodeParent = assetsCodeParent;
	}

	public String getAssetsCodeParent() {
		return this.assetsCodeParent;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return this.model;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setAssetsSortCode(String assetsSortCode) {
		this.assetsSortCode = assetsSortCode;
	}

	public String getAssetsSortCode() {
		return this.assetsSortCode;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setBaseDepCode(String baseDepCode) {
		this.baseDepCode = baseDepCode;
	}

	public String getBaseDepCode() {
		return this.baseDepCode;
	}

	public void setBaseDepName(String baseDepName) {
		this.baseDepName = baseDepName;
	}

	public String getBaseDepName() {
		return this.baseDepName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setBaseTeacherNoKeeper(String baseTeacherNoKeeper) {
		this.baseTeacherNoKeeper = baseTeacherNoKeeper;
	}

	public String getBaseTeacherNoKeeper() {
		return this.baseTeacherNoKeeper;
	}

	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}

	public String getKeeperName() {
		return this.keeperName;
	}

	public void setBaseRoomId(Long baseRoomId) {
		this.baseRoomId = baseRoomId;
	}

	public Long getBaseRoomId() {
		return this.baseRoomId;
	}

	public void setBaseRoomName(String baseRoomName) {
		this.baseRoomName = baseRoomName;
	}

	public String getBaseRoomName() {
		return this.baseRoomName;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPurchaser() {
		return this.purchaser;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPriceDollar(BigDecimal priceDollar) {
		this.priceDollar = priceDollar;
	}

	public BigDecimal getPriceDollar() {
		return this.priceDollar;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setOutlaySubject(String outlaySubject) {
		this.outlaySubject = outlaySubject;
	}

	public String getOutlaySubject() {
		return this.outlaySubject;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	public Date getStockDate() {
		return this.stockDate;
	}

	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}

	public String getAssessor() {
		return this.assessor;
	}

	public void setManageLevel(String manageLevel) {
		this.manageLevel = manageLevel;
	}

	public String getManageLevel() {
		return this.manageLevel;
	}

	public void setDepresiationMethod(String depresiationMethod) {
		this.depresiationMethod = depresiationMethod;
	}

	public String getDepresiationMethod() {
		return this.depresiationMethod;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getSrNo() {
		return this.srNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Date getServiceDate() {
		return this.serviceDate;
	}

	public void setFactoryDate(Date factoryDate) {
		this.factoryDate = factoryDate;
	}

	public Date getFactoryDate() {
		return this.factoryDate;
	}

	public void setFactoryNo(String factoryNo) {
		this.factoryNo = factoryNo;
	}

	public String getFactoryNo() {
		return this.factoryNo;
	}

	public void setState(Float state) {
		this.state = state;
	}

	public Float getState() {
		return this.state;
	}

	public void setCheckCycle(Long checkCycle) {
		this.checkCycle = checkCycle;
	}

	public Long getCheckCycle() {
		return this.checkCycle;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getChecker() {
		return this.checker;
	}

	public void setLastCheckDate(Date lastCheckDate) {
		this.lastCheckDate = lastCheckDate;
	}

	public Date getLastCheckDate() {
		return this.lastCheckDate;
	}

	public void setFinanceDate(Date financeDate) {
		this.financeDate = financeDate;
	}

	public Date getFinanceDate() {
		return this.financeDate;
	}

	public void setFinanceAssessor(String financeAssessor) {
		this.financeAssessor = financeAssessor;
	}

	public String getFinanceAssessor() {
		return this.financeAssessor;
	}

	public void setFinanceBill(String financeBill) {
		this.financeBill = financeBill;
	}

	public String getFinanceBill() {
		return this.financeBill;
	}

	public void setFinanceState(String financeState) {
		this.financeState = financeState;
	}

	public String getFinanceState() {
		return this.financeState;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp1() {
		return this.temp1;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getTemp2() {
		return this.temp2;
	}

	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}

	public String getTemp3() {
		return this.temp3;
	}

	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}

	public String getTemp4() {
		return this.temp4;
	}

	public void setTemp5(String temp5) {
		this.temp5 = temp5;
	}

	public String getTemp5() {
		return this.temp5;
	}

	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	public String getCheckMethod() {
		return this.checkMethod;
	}

	public void setOutlayCardNo(String outlayCardNo) {
		this.outlayCardNo = outlayCardNo;
	}

	public String getOutlayCardNo() {
		return this.outlayCardNo;
	}

	public void setPrinciple(String principle) {
		this.principle = principle;
	}

	public String getPrinciple() {
		return this.principle;
	}

	public void setTrafficCharge(BigDecimal trafficCharge) {
		this.trafficCharge = trafficCharge;
	}

	public BigDecimal getTrafficCharge() {
		return this.trafficCharge;
	}

	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}

	public BigDecimal getLateFee() {
		return this.lateFee;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setCheckAndAccept(String checkAndAccept) {
		this.checkAndAccept = checkAndAccept;
	}

	public String getCheckAndAccept() {
		return this.checkAndAccept;
	}

	public void setOutlayCardName(String outlayCardName) {
		this.outlayCardName = outlayCardName;
	}

	public String getOutlayCardName() {
		return this.outlayCardName;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getInputCode() {
		return this.inputCode;
	}

	public void setShopMan(String shopMan) {
		this.shopMan = shopMan;
	}

	public String getShopMan() {
		return this.shopMan;
	}

	public void setAssetsProducerCode(String assetsProducerCode) {
		this.assetsProducerCode = assetsProducerCode;
	}

	public String getAssetsProducerCode() {
		return this.assetsProducerCode;
	}

	public void setShopSupplierNo(String shopSupplierNo) {
		this.shopSupplierNo = shopSupplierNo;
	}

	public String getShopSupplierNo() {
		return this.shopSupplierNo;
	}

	public void setCanFlitting(Long canFlitting) {
		this.canFlitting = canFlitting;
	}

	public Long getCanFlitting() {
		return this.canFlitting;
	}

	public void setTechnicalTarget(String technicalTarget) {
		this.technicalTarget = technicalTarget;
	}

	public String getTechnicalTarget() {
		return this.technicalTarget;
	}

	public void setAccompanyInfo(String accompanyInfo) {
		this.accompanyInfo = accompanyInfo;
	}

	public String getAccompanyInfo() {
		return this.accompanyInfo;
	}

	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}

	public String getAccessoriesName() {
		return this.accessoriesName;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setAttachNum(Long attachNum) {
		this.attachNum = attachNum;
	}

	public Long getAttachNum() {
		return this.attachNum;
	}

	public void setAttachPrice(BigDecimal attachPrice) {
		this.attachPrice = attachPrice;
	}

	public BigDecimal getAttachPrice() {
		return this.attachPrice;
	}

	public void setAssetsSortName(String assetsSortName) {
		this.assetsSortName = assetsSortName;
	}

	public String getAssetsSortName() {
		return this.assetsSortName;
	}

	public void setDefaultCheckCycle(Long defaultCheckCycle) {
		this.defaultCheckCycle = defaultCheckCycle;
	}

	public Long getDefaultCheckCycle() {
		return this.defaultCheckCycle;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getBelong() {
		return this.belong;
	}

	public void setShBargainNo(String shBargainNo) {
		this.shBargainNo = shBargainNo;
	}

	public String getShBargainNo() {
		return this.shBargainNo;
	}

	public void setFinanceBaseTeacherNo(String financeBaseTeacherNo) {
		this.financeBaseTeacherNo = financeBaseTeacherNo;
	}

	public String getFinanceBaseTeacherNo() {
		return this.financeBaseTeacherNo;
	}

	public void setFinanceData(String financeData) {
		this.financeData = financeData;
	}

	public String getFinanceData() {
		return this.financeData;
	}

	public void setPriceForeignType(String priceForeignType) {
		this.priceForeignType = priceForeignType;
	}

	public String getPriceForeignType() {
		return this.priceForeignType;
	}

	public void setLargeTechParam(String largeTechParam) {
		this.largeTechParam = largeTechParam;
	}

	public String getLargeTechParam() {
		return this.largeTechParam;
	}

	public void setLargeDescription(String largeDescription) {
		this.largeDescription = largeDescription;
	}

	public String getLargeDescription() {
		return this.largeDescription;
	}

	public void setLargeServiceArea(String largeServiceArea) {
		this.largeServiceArea = largeServiceArea;
	}

	public String getLargeServiceArea() {
		return this.largeServiceArea;
	}

	public void setLargeMainFunction(String largeMainFunction) {
		this.largeMainFunction = largeMainFunction;
	}

	public String getLargeMainFunction() {
		return this.largeMainFunction;
	}

	public void setLargeDemonstrateCode(String largeDemonstrateCode) {
		this.largeDemonstrateCode = largeDemonstrateCode;
	}

	public String getLargeDemonstrateCode() {
		return this.largeDemonstrateCode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getNum() {
		return this.num;
	}

	public void setZjzt(String zjzt) {
		this.zjzt = zjzt;
	}

	public String getZjzt() {
		return this.zjzt;
	}

	public void setZjff(String zjff) {
		this.zjff = zjff;
	}

	public String getZjff() {
		return this.zjff;
	}

	public void setZjysx(Long zjysx) {
		this.zjysx = zjysx;
	}

	public Long getZjysx() {
		return this.zjysx;
	}

	public void setYzjys(Long yzjys) {
		this.yzjys = yzjys;
	}

	public Long getYzjys() {
		return this.yzjys;
	}

	public void setZjczl(Long zjczl) {
		this.zjczl = zjczl;
	}

	public Long getZjczl() {
		return this.zjczl;
	}

	public void setOutlaySubjectName(String outlaySubjectName) {
		this.outlaySubjectName = outlaySubjectName;
	}

	public String getOutlaySubjectName() {
		return this.outlaySubjectName;
	}

	public void setConfirmState(Long confirmState) {
		this.confirmState = confirmState;
	}

	public Long getConfirmState() {
		return this.confirmState;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getSubType() {
		return this.subType;
	}

	public void setConfirmReject(String confirmReject) {
		this.confirmReject = confirmReject;
	}

	public String getConfirmReject() {
		return this.confirmReject;
	}

	public void setImageList(String imageList) {
		this.imageList = imageList;
	}

	public String getImageList() {
		return this.imageList;
	}

	public void setFileList(String fileList) {
		this.fileList = fileList;
	}

	public String getFileList() {
		return this.fileList;
	}

	public void setFurnitureBatchCode(String furnitureBatchCode) {
		this.furnitureBatchCode = furnitureBatchCode;
	}

	public String getFurnitureBatchCode() {
		return this.furnitureBatchCode;
	}

	public void setIsImport(Long isImport) {
		this.isImport = isImport;
	}

	public Long getIsImport() {
		return this.isImport;
	}

	public void setAgentFee(BigDecimal agentFee) {
		this.agentFee = agentFee;
	}

	public BigDecimal getAgentFee() {
		return this.agentFee;
	}

	public void setCgzzxs(String cgzzxs) {
		this.cgzzxs = cgzzxs;
	}

	public String getCgzzxs() {
		return this.cgzzxs;
	}

	public void setCaizxjfly(BigDecimal caizxjfly) {
		this.caizxjfly = caizxjfly;
	}

	public BigDecimal getCaizxjfly() {
		return this.caizxjfly;
	}

	public void setQitjfly(BigDecimal qitjfly) {
		this.qitjfly = qitjfly;
	}

	public BigDecimal getQitjfly() {
		return this.qitjfly;
	}

	public void setDispdate(Date dispdate) {
		this.dispdate = dispdate;
	}

	public Date getDispdate() {
		return this.dispdate;
	}

	public void setChanqxs(String chanqxs) {
		this.chanqxs = chanqxs;
	}

	public String getChanqxs() {
		return this.chanqxs;
	}

	public void setChejh(String chejh) {
		this.chejh = chejh;
	}

	public String getChejh() {
		return this.chejh;
	}

	public void setCheph(String cheph) {
		this.cheph = cheph;
	}

	public String getCheph() {
		return this.cheph;
	}

	public void setFadjh(String fadjh) {
		this.fadjh = fadjh;
	}

	public String getFadjh() {
		return this.fadjh;
	}

	public void setPaiql(String paiql) {
		this.paiql = paiql;
	}

	public String getPaiql() {
		return this.paiql;
	}

	public void setBianzqk(String bianzqk) {
		this.bianzqk = bianzqk;
	}

	public String getBianzqk() {
		return this.bianzqk;
	}

	public void setYongtfl(String yongtfl) {
		this.yongtfl = yongtfl;
	}

	public String getYongtfl() {
		return this.yongtfl;
	}

	public void setWenwdj(String wenwdj) {
		this.wenwdj = wenwdj;
	}

	public String getWenwdj() {
		return this.wenwdj;
	}

	public void setGuanldw(String guanldw) {
		this.guanldw = guanldw;
	}

	public String getGuanldw() {
		return this.guanldw;
	}

	public void setZhucdjjg(String zhucdjjg) {
		this.zhucdjjg = zhucdjjg;
	}

	public String getZhucdjjg() {
		return this.zhucdjjg;
	}

	public void setZhucdjsj(Date zhucdjsj) {
		this.zhucdjsj = zhucdjsj;
	}

	public Date getZhucdjsj() {
		return this.zhucdjsj;
	}

	public void setZhuanlh(String zhuanlh) {
		this.zhuanlh = zhuanlh;
	}

	public String getZhuanlh() {
		return this.zhuanlh;
	}

	public void setPizwh(String pizwh) {
		this.pizwh = pizwh;
	}

	public String getPizwh() {
		return this.pizwh;
	}

	public void setChelcd(String chelcd) {
		this.chelcd = chelcd;
	}

	public String getChelcd() {
		return this.chelcd;
	}

	public void setZuows(Long zuows) {
		this.zuows = zuows;
	}

	public Long getZuows() {
		return this.zuows;
	}

	public void setDispid(Long dispid) {
		this.dispid = dispid;
	}

	public Long getDispid() {
		return this.dispid;
	}

	public void setFinanceSort(String financeSort) {
		this.financeSort = financeSort;
	}

	public String getFinanceSort() {
		return this.financeSort;
	}

	public void setGzCategory(String gzCategory) {
		this.gzCategory = gzCategory;
	}

	public String getGzCategory() {
		return this.gzCategory;
	}

	public void setJybCategory(String jybCategory) {
		this.jybCategory = jybCategory;
	}

	public String getJybCategory() {
		return this.jybCategory;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	public BigDecimal getStockPrice() {
		return this.stockPrice;
	}

	public void setGgCode(String ggCode) {
		this.ggCode = ggCode;
	}

	public String getGgCode() {
		return this.ggCode;
	}

	public void setFtBargainNo(String ftBargainNo) {
		this.ftBargainNo = ftBargainNo;
	}

	public String getFtBargainNo() {
		return this.ftBargainNo;
	}

	public void setIsCar(Long isCar) {
		this.isCar = isCar;
	}

	public Long getIsCar() {
		return this.isCar;
	}

	public void setRequestBpmNo(String requestBpmNo) {
		this.requestBpmNo = requestBpmNo;
	}

	public String getRequestBpmNo() {
		return this.requestBpmNo;
	}

	public void setChelx(String chelx) {
		this.chelx = chelx;
	}

	public String getChelx() {
		return this.chelx;
	}

	public void setDangah(String dangah) {
		this.dangah = dangah;
	}

	public String getDangah() {
		return this.dangah;
	}

	public void setCangpnd(String cangpnd) {
		this.cangpnd = cangpnd;
	}

	public String getCangpnd() {
		return this.cangpnd;
	}

	public void setBaocnx(String baocnx) {
		this.baocnx = baocnx;
	}

	public String getBaocnx() {
		return this.baocnx;
	}

	public void setChubrq(String chubrq) {
		this.chubrq = chubrq;
	}

	public String getChubrq() {
		return this.chubrq;
	}

	public void setChuszznf(Long chuszznf) {
		this.chuszznf = chuszznf;
	}

	public Long getChuszznf() {
		return this.chuszznf;
	}

	public void setYujsmzl(BigDecimal yujsmzl) {
		this.yujsmzl = yujsmzl;
	}

	public BigDecimal getYujsmzl() {
		return this.yujsmzl;
	}

	public void setGangsk(String gangsk) {
		this.gangsk = gangsk;
	}

	public String getGangsk() {
		return this.gangsk;
	}

	public void setFamr(String famr) {
		this.famr = famr;
	}

	public String getFamr() {
		return this.famr;
	}

	public void setZhengsh(String zhengsh) {
		this.zhengsh = zhengsh;
	}

	public String getZhengsh() {
		return this.zhengsh;
	}

	public void setFammc(String fammc) {
		this.fammc = fammc;
	}

	public String getFammc() {
		return this.fammc;
	}

	public void setShebytid(String shebytid) {
		this.shebytid = shebytid;
	}

	public String getShebytid() {
		return this.shebytid;
	}

	public void setChelxszsyr(String chelxszsyr) {
		this.chelxszsyr = chelxszsyr;
	}

	public String getChelxszsyr() {
		return this.chelxszsyr;
	}

	public void setJingz(BigDecimal jingz) {
		this.jingz = jingz;
	}

	public BigDecimal getJingz() {
		return this.jingz;
	}

	public void setLeijzj(BigDecimal leijzj) {
		this.leijzj = leijzj;
	}

	public BigDecimal getLeijzj() {
		return this.leijzj;
	}

	public void setJiazlx(String jiazlx) {
		this.jiazlx = jiazlx;
	}

	public String getJiazlx() {
		return this.jiazlx;
	}

	public void setImportMsNo(String importMsNo) {
		this.importMsNo = importMsNo;
	}

	public String getImportMsNo() {
		return this.importMsNo;
	}

	public void setIsInProcEqu(Long isInProcEqu) {
		this.isInProcEqu = isInProcEqu;
	}

	public Long getIsInProcEqu() {
		return this.isInProcEqu;
	}

	public void setInProcEquId(Long inProcEquId) {
		this.inProcEquId = inProcEquId;
	}

	public Long getInProcEquId() {
		return this.inProcEquId;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BigDecimal getBookPrice() {
		return this.bookPrice;
	}

	public void setPriceType(Long priceType) {
		this.priceType = priceType;
	}

	public Long getPriceType() {
		return this.priceType;
	}

	public void setAssessCompany(String assessCompany) {
		this.assessCompany = assessCompany;
	}

	public String getAssessCompany() {
		return this.assessCompany;
	}

	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}

	public String getAssessName() {
		return this.assessName;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setXcfs(String xcfs) {
		this.xcfs = xcfs;
	}

	public String getXcfs() {
		return this.xcfs;
	}

	public void setTempDate(Date tempDate) {
		this.tempDate = tempDate;
	}

	public Date getTempDate() {
		return this.tempDate;
	}

	public void setBudgetProjectNo(String budgetProjectNo) {
		this.budgetProjectNo = budgetProjectNo;
	}

	public String getBudgetProjectNo() {
		return this.budgetProjectNo;
	}

	public void setShouynx(Long shouynx) {
		this.shouynx = shouynx;
	}

	public Long getShouynx() {
		return this.shouynx;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public Date getUseDate() {
		return this.useDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}

	public Long getBookNum() {
		return this.bookNum;
	}

	public void setBookTypes(Long bookTypes) {
		this.bookTypes = bookTypes;
	}

	public Long getBookTypes() {
		return this.bookTypes;
	}

	public void setFormedMethod(Long formedMethod) {
		this.formedMethod = formedMethod;
	}

	public Long getFormedMethod() {
		return this.formedMethod;
	}

	public void setImportCd(String importCd) {
		this.importCd = importCd;
	}

	public String getImportCd() {
		return this.importCd;
	}

	public void setImportPort(String importPort) {
		this.importPort = importPort;
	}

	public String getImportPort() {
		return this.importPort;
	}

	public void setImportCustoms(String importCustoms) {
		this.importCustoms = importCustoms;
	}

	public String getImportCustoms() {
		return this.importCustoms;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Date getImportDate() {
		return this.importDate;
	}

	public void setIsShare(Long isShare) {
		this.isShare = isShare;
	}

	public Long getIsShare() {
		return this.isShare;
	}

	public void setIsChargeStandard(Long isChargeStandard) {
		this.isChargeStandard = isChargeStandard;
	}

	public Long getIsChargeStandard() {
		return this.isChargeStandard;
	}

	public void setHsNo(String hsNo) {
		this.hsNo = hsNo;
	}

	public String getHsNo() {
		return this.hsNo;
	}

	public void setManagerRemark(String managerRemark) {
		this.managerRemark = managerRemark;
	}

	public String getManagerRemark() {
		return this.managerRemark;
	}

	public void setDropBpmNo(Long dropBpmNo) {
		this.dropBpmNo = dropBpmNo;
	}

	public Long getDropBpmNo() {
		return this.dropBpmNo;
	}

	public void setTemp6(String temp6) {
		this.temp6 = temp6;
	}

	public String getTemp6() {
		return this.temp6;
	}

	public void setTemp7(String temp7) {
		this.temp7 = temp7;
	}

	public String getTemp7() {
		return this.temp7;
	}

	public void setTemp8(String temp8) {
		this.temp8 = temp8;
	}

	public String getTemp8() {
		return this.temp8;
	}

	public void setTemp9(String temp9) {
		this.temp9 = temp9;
	}

	public String getTemp9() {
		return this.temp9;
	}

	public void setTemp10(String temp10) {
		this.temp10 = temp10;
	}

	public String getTemp10() {
		return this.temp10;
	}

	public String getAssetsUser() {
		return assetsUser;
	}

	public void setAssetsUser(String assetsUser) {
		this.assetsUser = assetsUser;
	}

	public void setRemarkMine(String remarkMine) {
		this.remarkMine = remarkMine;
	}

	public String getRemarkMine() {
		return this.remarkMine;
	}

	public void setRemarkManager(String remarkManager) {
		this.remarkManager = remarkManager;
	}

	public String getRemarkManager() {
		return this.remarkManager;
	}

	public void setRemarkDivision(String remarkDivision) {
		this.remarkDivision = remarkDivision;
	}

	public String getRemarkDivision() {
		return this.remarkDivision;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getRfid() {
		return this.rfid;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCampus() {
		return this.campus;
	}

	public String getCheckUseState() {
		return checkUseState;
	}

	public void setCheckUseState(String checkUseState) {
		this.checkUseState = checkUseState;
	}

	public String getInvoiceImageList() {
		return invoiceImageList;
	}

	public void setInvoiceImageList(String invoiceImageList) {
		this.invoiceImageList = invoiceImageList;
	}

	/**
	 * @return the isOpenShare
	 */
	public Long getIsOpenShare() {
		return isOpenShare;
	}

	/**
	 * @param isOpenShare
	 *            the isOpenShare to set
	 */
	public void setIsOpenShare(Long isOpenShare) {
		this.isOpenShare = isOpenShare;
	}

	/**
	 * @return the technicalProvider
	 */
	public String getTechnicalProvider() {
		return technicalProvider;
	}

	/**
	 * @param technicalProvider
	 *            the technicalProvider to set
	 */
	public void setTechnicalProvider(String technicalProvider) {
		this.technicalProvider = technicalProvider;
	}

	/**
	 * @return the customsSupervisionSituation
	 */
	public Long getCustomsSupervisionSituation() {
		return customsSupervisionSituation;
	}

	/**
	 * @param customsSupervisionSituation
	 *            the customsSupervisionSituation to set
	 */
	public void setCustomsSupervisionSituation(Long customsSupervisionSituation) {
		this.customsSupervisionSituation = customsSupervisionSituation;
	}

	/**
	 * @return the securityType
	 */
	public Long getSecurityType() {
		return securityType;
	}

	/**
	 * @param securityType
	 *            the securityType to set
	 */
	public void setSecurityType(Long securityType) {
		this.securityType = securityType;
	}

	/**
	 * @return the donors
	 */
	public String getDonors() {
		return donors;
	}

	/**
	 * @param donors
	 *            the donors to set
	 */
	public void setDonors(String donors) {
		this.donors = donors;
	}

	/**
	 * @return the labTelephone
	 */
	public String getLabTelephone() {
		return labTelephone;
	}

	/**
	 * @param labTelephone
	 *            the labTelephone to set
	 */
	public void setLabTelephone(String labTelephone) {
		this.labTelephone = labTelephone;
	}

	/**
	 * @return the assetsBooksSortCode
	 */
	public String getAssetsBooksSortCode() {
		return assetsBooksSortCode;
	}

	/**
	 * @param assetsBooksSortCode
	 *            the assetsBooksSortCode to set
	 */
	public void setAssetsBooksSortCode(String assetsBooksSortCode) {
		this.assetsBooksSortCode = assetsBooksSortCode;
	}

	/**
	 * @return the assetsBooksSortName
	 */
	public String getAssetsBooksSortName() {
		return assetsBooksSortName;
	}

	/**
	 * @param assetsBooksSortName
	 *            the assetsBooksSortName to set
	 */
	public void setAssetsBooksSortName(String assetsBooksSortName) {
		this.assetsBooksSortName = assetsBooksSortName;
	}

	public Integer getClassified() {
		return classified;
	}

	public void setClassified(Integer classified) {
		this.classified = classified;
	}

	public Integer getAuthorizationNum() {
		return authorizationNum;
	}

	public void setAuthorizationNum(Integer authorizationNum) {
		this.authorizationNum = authorizationNum;
	}

	public Integer getAuthorizationYear() {
		return authorizationYear;
	}

	public void setAuthorizationYear(Integer authorizationYear) {
		this.authorizationYear = authorizationYear;
	}

	public String getImageTemp1() {
		return imageTemp1;
	}

	public void setImageTemp1(String imageTemp1) {
		this.imageTemp1 = imageTemp1;
	}

	public String getImageTemp2() {
		return imageTemp2;
	}

	public void setImageTemp2(String imageTemp2) {
		this.imageTemp2 = imageTemp2;
	}

	public String getImageTemp3() {
		return imageTemp3;
	}

	public void setImageTemp3(String imageTemp3) {
		this.imageTemp3 = imageTemp3;
	}

	public Double getWorkRate() {
		return workRate;
	}

	public void setWorkRate(Double workRate) {
		this.workRate = workRate;
	}

	public Date getAcceptanceDate() {
		return acceptanceDate;
	}

	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}

	/**
	 * @return the isSpecial
	 */
	public Long getIsSpecial() {
		return isSpecial;
	}

	/**
	 * @param isSpecial
	 *            the isSpecial to set
	 */
	public void setIsSpecial(Long isSpecial) {
		this.isSpecial = isSpecial;
	}

	/**
	 * @return the disposalSalePrice
	 */
	public BigDecimal getDisposalSalePrice() {
		return disposalSalePrice;
	}

	/**
	 * @param disposalSalePrice
	 *            the disposalSalePrice to set
	 */
	public void setDisposalSalePrice(BigDecimal disposalSalePrice) {
		this.disposalSalePrice = disposalSalePrice;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getSubscribeType() {
		return subscribeType;
	}

	public void setSubscribeType(String subscribeType) {
		this.subscribeType = subscribeType;
	}

	public Long getDbSortIdSecond() {
		return dbSortIdSecond;
	}

	public void setDbSortIdSecond(Long dbSortIdSecond) {
		this.dbSortIdSecond = dbSortIdSecond;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getEissn() {
		return eissn;
	}

	public void setEissn(String eissn) {
		this.eissn = eissn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Long publishYear) {
		this.publishYear = publishYear;
	}

	public Long getYearStart() {
		return yearStart;
	}

	public void setYearStart(Long yearStart) {
		this.yearStart = yearStart;
	}

	public Long getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(Long yearEnd) {
		this.yearEnd = yearEnd;
	}

	public String getFinanceBillPricechange() {
		return financeBillPricechange;
	}

	public void setFinanceBillPricechange(String financeBillPricechange) {
		this.financeBillPricechange = financeBillPricechange;
	}
	
	public BigDecimal getCustomsDuty() {
		return customsDuty;
	}

	public void setCustomsDuty(BigDecimal customsDuty) {
		this.customsDuty = customsDuty;
	}

	public String getOutlayBaseDepCode() {
		return outlayBaseDepCode;
	}

	public void setOutlayBaseDepCode(String outlayBaseDepCode) {
		this.outlayBaseDepCode = outlayBaseDepCode;
	}

	public String getOutlayBaseDepName() {
		return outlayBaseDepName;
	}

	public void setOutlayBaseDepName(String outlayBaseDepName) {
		this.outlayBaseDepName = outlayBaseDepName;
	}

}