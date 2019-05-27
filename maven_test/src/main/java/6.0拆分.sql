---------------------- 第一部分：耗材   material ----------------
-- 更新单据模板文件路径
update business_bill_template set path = regexp_replace(path, '^/source/assets/', '/product/assets/material/')
 where action like '%material%'
   and path like '/source/assets/%';
   
-- 更新单据数据源地址
update business_bill_template set action = regexp_replace(action, '^assets.', 'assets.material.') where action like 'assets.%material%';

update business_bill_template set action1 = regexp_replace(action1, '^assets.', 'assets.material.') where action1 like 'assets.%material%';

update business_bill_template set action2 = regexp_replace(action2, '^assets.', 'assets.material.') where action2 like 'assets.%material%';

update business_bill_template set action3 = regexp_replace(action3, '^assets.', 'assets.material.') where action3 like 'assets.%material%';

update business_process_node set audit_url = regexp_replace(audit_url, '^assets.', 'assets.material.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange','materialcheck','materialrecycle'))
   and audit_url like 'assets.%';
   
update business_process set detail_url = replace(detail_url, 'e?page=assets.', 'e?page=assets.material.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange','materialcheck','materialrecycle'))
   and detail_url like 'e?page=assets.%';
   
update business_process set back_action = replace(back_action, 'e?page=assets.', 'e?page=assets.material.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange','materialcheck','materialrecycle'))
   and detail_url like 'e?page=assets.%';

update business_process set define_file = '/product/assets/material' || define_file
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange','materialcheck','materialrecycle'))
   and define_file not like '/source/%';
   
 update business_process set define_file = regexp_replace(define_file, '^/source/assets/', '/product/assets/material/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange','materialcheck','materialrecycle'))
    and define_file like '/source/assets/%';
    
update business_process set define_file = replace(define_file, '\', '/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange',
                                         'materialcheck','materialrecycle'))
   and define_file like '%\%';
   
update business_bill set action_url = regexp_replace(action_url, '^assets.', 'assets.material.')
 where business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('materialchange','materialcheck','materialrecycle'))
   and action_url like 'assets.%';
   
commit;

---------------------- 第二部分：验收建账   acceptance ----------------

-- 更细流程节点审核地址
update business_process_node set audit_url = regexp_replace(audit_url, '^assets.', 'assets.acceptance.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('accept','project'))
   and audit_url like 'assets.%';

-- 更新业务详情地址
update business_process set detail_url = replace(detail_url, 'e?page=assets.', 'e?page=assets.acceptance.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('accept','project'))
   and detail_url like 'e?page=assets.%';
     
-- 更新业务撤回地址
update business_process set back_action = regexp_replace(back_action, '^assets.', 'assets.acceptance.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('accept','project'))
   and back_action like 'assets.%';
     
-- 更新流程文件地址
update business_process set define_file = '/product/assets/acceptance' || define_file
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('accept','project'))
   and define_file not like '/source/%';
     
 update business_process set define_file = regexp_replace(define_file, '^/source/assets/', '/product/assets/acceptance/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('accept','project'))
   and define_file like '/source/assets/%';
-- 更新单据数据源地址
update business_bill set action_url = regexp_replace(action_url, '^assets.', 'assets.acceptance.')
 where business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('accept','project'))
   and action_url like 'assets.%';
     
-- 更新单据模板文件路径
update business_bill_template set path = '/product/assets/acceptance' || path
 where action like 'assets.%' and (action like '%accept%' or action like '%project%') and action not like '%material%'
   and path like '%/%'
   and path not like '/source/assets/%';
 
update business_bill_template set path = regexp_replace(path, '^/source/assets/', '/product/assets/acceptance/')
 where action like 'assets.%' and (action like '%accept%' or action like '%project%') and action not like '%material%'
   and path like '/source/assets/%';

update business_bill_template set path = replace(path, '\', '/')
 where action like 'assets.%' and (action like '%accept%' or action like '%project%') and action not like '%material%'
   and path like '%\%';
     
 -- 更新单据数据源地址
update business_bill_template set action = regexp_replace(action, '^assets.', 'assets.acceptance.') where action like 'assets.%' and (action like '%accept%' or action like '%project%') and action not like '%material%';
update business_bill_template set action1 = regexp_replace(action1, '^assets.', 'assets.acceptance.') where action1 like 'assets.%' and (action1 like '%accept%' or action1 like '%project%') and action1 not like '%material%';
update business_bill_template set action2 = regexp_replace(action2, '^assets.', 'assets.acceptance.') where action2 like 'assets.%' and (action2 like '%accept%' or action2 like '%project%') and action2 not like '%material%';
update business_bill_template set action3 = regexp_replace(action3, '^assets.', 'assets.acceptance.') where action3 like 'assets.%' and (action3 like '%accept%' or action3 like '%project%') and action3 not like '%material%';

commit;

---------------------- 第三部分：清查盘点   check ----------------

-- 更细流程节点审核地址 
update business_process_node set audit_url = regexp_replace(audit_url, '^assets.', 'assets.check.')
  where system_product_code = 'assets'
   and business_code in
       (select code
          from business
         where system_product_code = 'assets'
           and type in
               ('check'))
   and audit_url like 'assets.%.check.%';

-- 更新业务详情地址
update business_process set detail_url = replace(detail_url, 'e?page=assets.', 'e?page=assets.check.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('check'))
   and detail_url like 'e?page=assets.%.check.detail';

-- 更新业务撤回地址  
update business_process set back_action = 'assets.check.backProcess'
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('check'))
   and back_action != 'assets.check.backProcess';

-- 更新流程文件地址
update business_process set define_file = '/product/assets/check' || define_file
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('check'))
   and define_file not like '/source/%';

update business_process set define_file = regexp_replace(define_file, '^/source/assets/', '/product/assets/check/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('check'))
   and define_file like '/source/assets/%';

update business_process set define_file = replace(define_file, '\', '/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('check'))
   and define_file like '%\%';

-- 更新单据模板文件路径
update business_bill_template set path = '/product/assets/check' || path
 where action like 'assets.%check%'
   and path like '%/%'
   and path not like '/source/assets/%';

update business_bill_template set path = regexp_replace(path, '^/source/assets/', '/product/assets/check/')
 where action like 'assets.%check%'
   and path like '/source/assets/%';

update business_bill_template set path = replace(path, '\', '/')
 where action like 'assets.%check%'
   and path like '%\%';

commit;

---------------------- 第四部分：变动处置   change ----------------

-- 更细流程节点审核地址 
update business_process_node set audit_url = regexp_replace(audit_url, '^assets.', 'assets.change.')
  where system_product_code = 'assets'
   and business_code in
       (select code
          from business
         where system_product_code = 'assets'
           and type in
               ('change', 'disposal', 'repair', 'swap', 'collection'))
   and audit_url like 'assets.%'
   and audit_url not like '%accept.revise';

-- 更新业务详情地址
update business_process set detail_url = replace(detail_url, 'e?page=assets.', 'e?page=assets.change.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and detail_url like 'e?page=assets.%';

-- 更新业务撤回地址          注：流程里可能配置的撤回action是 assets.accept.backProcess，替换之后，还要去把accept.替换掉，补充backAction 为空的
update business_process set back_action = regexp_replace(back_action, '^assets.', 'assets.change.')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and back_action like 'assets.%' and back_action not like 'assets.change.%';

update business_process set back_action = replace(back_action, 'accept.', '')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and back_action like '%accept.%';
   
update business_process set back_action = 'assets.change.backProcess'
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and detail_url like 'e?page=assets.change.%'
   and back_action is null ;

-- 更新流程文件地址
update business_process set define_file = '/product/assets/change' || define_file
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and define_file not like '/source/%';

update business_process set define_file = regexp_replace(define_file, '^/source/assets/', '/product/assets/change/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and define_file like '/source/assets/%';

update business_process set define_file = replace(define_file, '\', '/')
 where system_product_code = 'assets'
   and business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and define_file like '%\%';

-- 更新单据数据源地址
update business_bill set action_url = regexp_replace(action_url, '^assets.', 'assets.change.')
 where business_code in (select code
                           from business
                          where system_product_code = 'assets'
                            and type in ('change',
                                         'disposal',
                                         'repair',
                                         'swap',
                                         'collection'))
   and action_url like 'assets.%';

-- 更新单据模板文件路径
update business_bill_template set path = '/product/assets/change' || path
 where (action like 'assets.%' and action not like '%accept%' and action not like '%material%'  and action not like '%check%' and action not like '%report%' and action not like '%account%' and action not like '%assetsQuery%')
   and path like '%/%'
   and path not like '/source/assets/%';

update business_bill_template set path = regexp_replace(path, '^/source/assets/', '/product/assets/change/')
 where (action like 'assets.%' and action not like '%accept%' and action not like '%material%'  and action not like '%check%' and action not like '%report%' and action not like '%account%' and action not like '%assetsQuery%')
   and path like '/source/assets/%';

update business_bill_template set path = replace(path, '\', '/')
 where (action like 'assets.%' and action not like '%accept%' and action not like '%material%'  and action not like '%check%' and action not like '%report%' and action not like '%account%' and action not like '%assetsQuery%')
   and path like '%\%';

-- 更新单据数据源地址
update business_bill_template set action = regexp_replace(action, '^assets.', 'assets.change.') where action like 'assets.%' and action not like '%accept%' and action not like '%material%'  and action not like '%check%' and action not like '%report%' and action not like '%account%' and action not like '%assetsQuery%';
update business_bill_template set action1 = regexp_replace(action1, '^assets.', 'assets.change.') where action1 like 'assets.%' and action1 not like '%accept%' and action1 not like '%material%'  and action1 not like '%check%' and action1 not like '%report%' and action1 not like '%account%' and action1 not like '%assetsQuery%';
update business_bill_template set action2 = regexp_replace(action2, '^assets.', 'assets.change.') where action2 like 'assets.%' and action2 not like '%accept%' and action2 not like '%material%'  and action2 not like '%check%' and action2 not like '%report%' and action2 not like '%account%' and action2 not like '%assetsQuery%';
update business_bill_template set action3 = regexp_replace(action3, '^assets.', 'assets.change.') where action3 like 'assets.%' and action3 not like '%accept%' and action3 not like '%material%'  and action3 not like '%check%' and action3 not like '%report%' and action3 not like '%account%' and action3 not like '%assetsQuery%';

-- 更新定时器地址        注：各个学校的定时任务 可能不一样，目前在19上发现的就这一个需要更新的，可能需要项目同事协助
update system_schedule set classz = regexp_replace(classz, '^cn.speedit.assets.', 'cn.speedit.assets.change.') where classz like '%assets.%' and classz like '%RefreshDisposalBiddingState%';

-- 更新配置模式地址
update system_view_config set page_code = regexp_replace(page_code, '^assets.', 'assets.change.') where product_code = 'assets' and page_code not like '%accept%' and page_code not like '%project%' and page_code not like '%material%';

-- 更新角色配置的首页地址
update system_view_homepage set manager_page = replace(manager_page, 'e?page=assets.', 'e?page=assets.change.')
 where manager_page like 'e?page=assets.%';

update system_view_homepage set division_page = replace(division_page, 'e?page=assets.', 'e?page=assets.change.')
 where division_page like 'e?page=assets.%';

-- 更新登录入口地址
update system_login_entry set usrcenter_page = replace(usrcenter_page, 'e?page=assets.', 'e?page=assets.change.')
 where usrcenter_page like 'e?page=assets.%';

update system_login_entry set manager_page = replace(manager_page, 'e?page=assets.', 'e?page=assets.change.')
 where manager_page like 'e?page=assets.%';

update system_login_entry set division_page = replace(division_page, 'e?page=assets.', 'e?page=assets.change.')
 where division_page like 'e?page=assets.%';

-- 更新系统首页地址
update system_workbench set home_page = replace(home_page, 'e?page=assets.', 'e?page=assets.change.') where home_page like 'e?page=assets.%';

commit;

---------------------- 第五部分：财务接口   finance ----------------

-- 更新定时器地址        
update system_schedule set classz = 'cn.speedit.assets.finance.RefreshFinanceState' where classz like 'cn.speedit.assets.%.RefreshFinanceState';
-- 更新配置模式地址
update system_view_config set page_code = regexp_replace(page_code, '^assets.', 'assets.acceptance.')
 where product_code = 'assets' and (page_code like '%accept%' or page_code like '%project%');

commit;

---------------------- 第六部分：查询统计报表   query ----------------

-- 更新单据模板文件路径

update business_bill_template set path = regexp_replace(path, '^/source/assets/', '/product/assets/query/')
 where action like 'assets.report%' and action not like 'assets.report%ybreport%'
   and path like '/source/assets/%';

update business_bill_template set action = replace(action, 'assets.report.', 'assets.query.report.')
 where action like 'assets.report%' and action not like 'assets.report%ybreport%';

commit;

---------------------- 第七部分：权限   system_popedom ----------------

--  新增或更改权限 --------

--update 部分：
  UPDATE SYSTEM_POPEDOM SET CODE = 'assets.acceptance.division.accept.*' WHERE ID = '303020101';
  UPDATE SYSTEM_POPEDOM SET CODE = 'assets.acceptance.personal.accept.*' WHERE ID = '3010302';

UPDATE SYSTEM_POPEDOM t SET t.code = replace(code,',','.') WHERE t.code like 'assets%material%' and code like '%,%';

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.material.') where code LIKE 'assets%material%';

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.material.') where id = 303100011;

UPDATE SYSTEM_POPEDOM SET CODE = regexp_replace(CODE, '^assets.', 'assets.acceptance.') WHERE CODE like 'assets%accept%' and code not like '%mall%';

UPDATE SYSTEM_POPEDOM SET CODE = regexp_replace(CODE, '^assets.', 'assets.acceptance.') WHERE CODE like 'assets%project.%';

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.check.')
 where code like 'assets.%check%'
 and code not like '%finance%'
  and code not like '%special%';

update system_popedom set code = regexp_replace(code, '^assets.check.check.', 'assets.check.')
where code like 'assets.check.check.%';

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.change.')
where code like 'assets.%'
 and (code like '%change%' or code like '%disposal%' or code like '%fix%' or code like '%repair%' or code like '%swap%' or code like '%collection%')
 and code not like '%material%';

update system_popedom set code = regexp_replace(code, '^assets.change.change.', 'assets.change.')
where code like 'assets.change.change.%'
 and (code like '%change%' or code like '%disposal%' or code like '%fix%'  or code like '%repair%' or code like '%swap%' or code like '%collection%')
 and code not like '%material%';

 --财务数据列表
update system_popedom set code = regexp_replace(code,'^assets.*.?finance.tabs','assets.finance.tabs') 
where code like 'assets%finance.tabs%' and is_menu = '1';

--财务未达账列表
update system_popedom set code = regexp_replace(code,'^assets.*.?financeUncollectedAssets','assets.finance.list_uncollected_assets') 
where (code like 'assets%financeUncollectedAssets%' or code like 'assets%list_uncollected_assets%') and is_menu = '1';

update system_popedom set code = regexp_replace(code,'^assets.*.?financeUncollectedBusiness','assets.finance.common.list_uncollected') 
where (code like 'assets%financeUncollectedBusiness%' or code like 'assets%list_uncollected%') and is_menu = '1';

--财务接口权限
update system_popedom set code = regexp_replace(code,'^assets.*.?finance','assets.finance') 
where code like 'assets%finance.%' and code not like 'assets%financeUncollected.%' and is_menu = '0';

--财务未达账权限
update system_popedom set code = regexp_replace(code,'^assets.*.?financeUncollected','assets.finance.financeUncollected') 
where code like 'assets%financeUncollected%' and is_menu = '0';

update system_popedom set code = 'assets.common.assets.*' where code = 'assets.change.common.assets.*';
update system_popedom set code = regexp_replace(code, '^assets.change.', 'assets.') where code like '%assets.detail%';

-- ConfigAction 和 CacheAction 移到 Common包
update SYSTEM_POPEDOM set code=  regexp_replace(code,'assets\.config','assets.common.config') where  code like 'assets.config.%';
update SYSTEM_POPEDOM set code = regexp_replace(code,'assets\.cache','assets.common.cache') where  code like 'assets.cache.%';

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.query.')
 where code like 'assets.%'
   and id like '3%'
   and code not like ('%material%')
   and code not like ('%terminal%')
   and code not like ('%moe%')
   and code not like ('%finance%')
   and code not like ('%accept%')
   and code not like ('%roject%')
   and code not like ('%check%')
   and code not like ('%swap%')
   and code not like ('%report%')
   and code not like ('%repair%')
   and code not like ('%disposal%')
   and code not like ('%.config%')
   and code not like ('%.data.%')
   and code not like ('%.mall.%')
   and code not like ('%backProcess%')
   and code not like ('%sso%')
   and code not like ('%.process.%')
   and code not like ('%fix%')
   and code not like ('%disposal.list')
   and code not like ('%repair.list')
   and code not like ('%change.list')
   and code not like ('%drop.list')
   and code not like ('%jybjk%')
   and code not like ('%pick%')
   and code not like ('%ollect%')
   and code not like ('%home%')
   and code not like ('%merge%')
   and code not like ('%.rule.%')
   and code not like ('%.assetsmodify.%')
   and code not like ('%inTheConstruction%')
   and code not like ('%.change.*')
   and code not like ('%.printBill.*')
   and code not like ('%.snapshot.*')
   and code not like ('%accounts.*')
   and code not like ('%.manager.*')
   and code not like ('%.cache.*')
   and code not like ('%.public.*')
   and code not like ('%.assetsModify.%')
   and code not like ('%.assets.*')
   and code not like ('%.common.*')
   and code not like ('%.division.*')
   and code not like ('%.personal.*')
   and code not like ('%.change.list_%')
   and code not like ('%_kjb')
   and code not like ('%modify_%')
   and code not like ('%.common.assets.detail')
   and code not like ('%.print_bill')
   and code not like ('%.common.businessEntry%');
  
--insert 部分：
  insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
  values (303020202, '变动业务权限', 'assets.change.division.change.*', null, 3030202, 2, null, 0, null, null, ',303020202,3030202,3030200,3030000,3000000,', null);

 insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
  values (3010401, '验收建账流程审核权限', 'assets.acceptance.process.*', null, 3010400, 1, null, 0, null, null, ',3010401,3010400,3010000,3000000,', null);

 insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
  values (3010402, '其他业务流程审核权限', 'assets.change.process.*', null, 3010400, 2, null, 0, null, null, ',3010402,3010400,3010000,3000000,', null);

 insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
  values (3020310, '单位业务验收建账权限', 'assets.acceptance.manager.*', null, 3020300, 2, null, 0, null, null, ',3020310,3020300,3020000,3000000,,', null);

 insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
  values (3010699, '验收建账公共权限', 'assets.acceptance.common.*', null, 3010600, 2, null, 0, null, null, ',3010699,3010600,3010000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3010612, '个人已处置资产', 'assets.query.personal.assets.list_drop', 'glyphicon glyphicon-trash', 3010600, 12, null, 0, null, null, ',3010612,3010600,3010000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (301010004, '个人资产修改', 'assets.query.personal.assets.modify', null, 3010100, null, null, 0, null, null, ',301010004,3010100,3010000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3020106, '单位资产修改-补充图片', 'assets.query.manager.assets.upload_image', null, 3020100, 0, null, 0, null, null, ',3020106,3020100,3020900,3020000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3020107, '单位资产修改页面', 'assets.query.manager.assets.modify', null, 3020100, 0, null, 0, null, null, ',3020107,3020100,3020900,3020000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3010696, '资产标签权限', 'assets.acceptance.accept.tag_code', null, 3010600, 2, null, 0, null, null, ',3010696,3010600,3010000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3020311, '统计概览查询权限', 'assets.query.manager.queryStatistic', null, 3020300, null, null, 0, null, null, ',3020311,3020300,3020000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3020309, '统计概览页面权限', 'assets.query.common.statistic_list', null, 3020300, null, null, 0, null, null, ',3020309,3020300,3020000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3020312, '资产概览页面初始化权限', 'assets.query.common.statistic', null, 3020300, null, null, 0, null, null, ',3020312,3020300,3020000,3000000,', null);

insert into SYSTEM_POPEDOM (code,system_popedom_id_parent,name,id,is_menu,parents) values ('assets.material.personal.materialchange.*',3011000,'个人试剂耗材业务权限',301100012,0,',301100012,3011000,3010000,3000000,');

insert into SYSTEM_POPEDOM (code,system_popedom_id_parent,name,id,is_menu,parents) values ('assets.material.process.materialchange.*',3011000,'试剂耗材业务审核权限',301100013,0,',301100013,3011000,3010000,3000000,');

insert into SYSTEM_POPEDOM (code,system_popedom_id_parent,name,id,is_menu,parents) values ('assets.material.accept.*',3011000,'试剂耗材验收建账业务权限',301100014,0,',301100014,3011000,3010000,3000000,');

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303000505, '报表查询权限', 'assets.query.report.statis.*', 'glyphicon glyphicon-stats', 3030005, 1, null, 0, null, null, ',303000505,3030005,3030000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303000506, '报表查询权限', 'assets.query.division.assets.list_change', 'glyphicon glyphicon-stats', 3030005, 6, null, 0, null, null, ',303000506,3030005,3030000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303000507, '报表查询权限', 'assets.query.division.assets.list_cannibalize', 'glyphicon glyphicon-stats', 3030005, 7, null, 0, null, null, ',303000507,3030005,3030000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303000508, '报表查询权限', 'assets.query.division.assets.list_add_detail', 'glyphicon glyphicon-stats', 3030005, 8, null, 0, null, null, ',303000508,3030005,3030000,3000000,', null);

insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303000509, '报表查询权限', 'assets.query.division.assets.list_decrease_detail', 'glyphicon glyphicon-stats', 3030005, 9, null, 0, null, null, ',303000509,3030005,3030000,3000000,', null);

insert into SYSTEM_POPEDOM (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303070003, '资产清查资产详情展示权限', 'assets.common.assets.detailBooks', null, 3030700, null, null, 0, null, null, ',303070003,3030700,3030000,3000000,', null);
--  end ---------------

commit;

---------------------- 第八部分：流程文件   wf_process ----------------

CREATE OR REPLACE FUNCTION convert_to_clob(l_blob BLOB) RETURN CLOB IS
   l_clob         CLOB;
   l_dest_offset  NUMBER := 1;
   l_src_offset   NUMBER := 1;
   l_lang_context NUMBER := dbms_lob.default_lang_ctx;
   l_warning      NUMBER;
BEGIN
   dbms_lob.createtemporary(l_clob, TRUE);
   dbms_lob.converttoclob(dest_lob     => l_clob,
                          src_blob     => l_blob,
                          amount       => dbms_lob.lobmaxsize,
                          dest_offset  => l_dest_offset,
                          src_offset   => l_src_offset,
                          blob_csid    => nls_charset_id('AL32UTF8'),
                          lang_context => l_lang_context,
                          warning      => l_warning);
   RETURN l_clob;
END convert_to_clob;
/

CREATE OR REPLACE FUNCTION convert_to_blob(l_clob CLOB) RETURN BLOB IS
   l_blob         BLOB;
   l_dest_offset  NUMBER := 1;
   l_src_offset   NUMBER := 1;
   l_lang_context NUMBER := dbms_lob.default_lang_ctx;
   l_warning      NUMBER;
BEGIN
   dbms_lob.createtemporary(l_blob, TRUE);
   dbms_lob.converttoblob(dest_lob     => l_blob,
                          src_clob     => l_clob,
                          amount       => dbms_lob.lobmaxsize,
                          dest_offset  => l_dest_offset,
                          src_offset   => l_src_offset,
                          blob_csid    => nls_charset_id('AL32UTF8'),
                          lang_context => l_lang_context,
                          warning      => l_warning);
   RETURN l_blob;
END convert_to_blob;
/

-- 更新流程问津中的泳道地址  material
update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'assignmentHandler="cn.speedit.assets.',
                                         'assignmentHandler="cn.speedit.assets.material.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and name like '%material%'
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%'
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%materialchange%';

update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'clazz="cn.speedit.assets.',
                                         'clazz="cn.speedit.assets.material.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and name like '%material%'
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.%';

-- 更新流程问津中的泳道地址  accept
update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'assignmentHandler="cn.speedit.assets.',
                                         'assignmentHandler="cn.speedit.assets.acceptance.'))
  where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%'
   and (convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%accept%' or
       convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%project%')
   and name not like '%material%';

update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'clazz="cn.speedit.assets.',
                                         'clazz="cn.speedit.assets.acceptance.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.%'
   and (convert_to_clob(content) like '%clazz="cn.speedit.assets.%accept%' or
       convert_to_clob(content) like '%clazz="cn.speedit.assets.%project%')
   and name not like '%material%';


-- 更新流程问津中的泳道地址    check
update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'assignmentHandler="cn.speedit.assets.',
                                         'assignmentHandler="cn.speedit.assets.check.'))
  where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%'
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%check%';

update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'clazz="cn.speedit.assets.',
                                         'clazz="cn.speedit.assets.check.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.%'
   and convert_to_clob(content) like
       '%clazz="cn.speedit.assets.%check%';

-- 更新流程问津中的泳道地址    finance

update wf_process
   set content = convert_to_blob(regexp_replace(convert_to_clob(content),
                                         'assignmentHandler="cn.speedit.assets.*.?Finance\w+Assignment',
                                         'assignmentHandler="cn.speedit.assets.finance.process.assignment.FinanceRequestAssignment'))
 where convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%.FinanceRequestAssignment%';

update wf_process
   set content = convert_to_blob(regexp_replace(convert_to_clob(content),
                                         'clazz="cn\.speedit\..*Finance\w+Han\w+er',
                                         'clazz="cn.speedit.assets.finance.process.hanlder.FinanceSubmitHandler'))
 where convert_to_clob(content) like  '%clazz="cn.speedit.%.Finance%Han%er%' ;


-- 更新流程问津中的泳道地址    change
update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'assignmentHandler="cn.speedit.assets.',
                                         'assignmentHandler="cn.speedit.assets.change.'))
  where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.%'
   and name not like '%material%'
   and convert_to_clob(content) not like
       '%assignmentHandler="cn.speedit.assets.%accept%'
   and convert_to_clob(content) not like
       '%assignmentHandler="cn.speedit.assets.%project%'
   and convert_to_clob(content) not like
       '%assignmentHandler="cn.speedit.assets.%finance%'
   and convert_to_clob(content) not like
       '%assignmentHandler="cn.speedit.assets.%check%';

update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'clazz="cn.speedit.assets.',
                                         'clazz="cn.speedit.assets.change.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.%'
   and name not like '%material%'
   and convert_to_clob(content) not like
       '%clazz="cn.speedit.assets.%accept%'
   and convert_to_clob(content) not like
       '%clazz="cn.speedit.assets.%project%'
   and convert_to_clob(content) not like
       '%clazz="cn.speedit.assets.%finance%'
   and convert_to_clob(content) not like
       '%clazz="cn.speedit.assets.%check%';

commit;

---------------------- 最后一部分：拆分调试   【最后执行】【最后执行】【最后执行】 ----------------

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.change.')
where id like '3%' and (code like 'assets.personal%' or code like 'assets.manager%' or code like 'assets.division%' or code like 'assets.common%' or code like '%moe%');

update system_popedom set code = regexp_replace(code,'^assets.','assets.query.') where code like '%.report.statis.index';

update system_popedom set code = regexp_replace(code, '^assets.query.', 'assets.acceptance.') where code like '%requestdep%';

update system_popedom set code = regexp_replace(code, '^assets.', 'assets.change.')
 where id like '3%' and code like 'assets.%'
   and code not like 'assets.acceptance%'
   and code not like 'assets.change%'
   and code not like 'assets.material%'
   and code not like 'assets.finance%'
   and code not like 'assets.query%'
   and code not like 'assets.check%'
   and code not like 'assets.common%'
   and code not like '%terminal%'
   and code not like '%mall%';
   
update system_popedom set code = regexp_replace(code, '^assets.change.', 'assets.query.')
 where id like '3%' and code like 'assets.%assets_category%';

update system_popedom set code = 'assets.change.personal.change.*' where id = 3010301;

-- 查询有多少权限 重复执行了数据，并进行修订  【start】      注：此段select 和 update 得多次执行，确保select 查询结果都为0才正确 --------
select count(*)
  from system_popedom
  where code like 'assets.acceptance.acceptance.%'
    union all
select count(*)
  from system_popedom
  where code like 'assets.material.material.%'
  union all
select count(*)
  from system_popedom
  where code like 'assets.change.change.%'
   union all
select count(*)
  from system_popedom
  where code like 'assets.check.check.%'
   union all
select count(*)
  from system_popedom
  where code like 'assets.finance.finance.%'
   union all
select count(*)
  from system_popedom
  where code like 'assets.query.query.%';

 ---  根据具体的查询结果，去更新数据

update system_popedom set code = replace(code, 'assets.acceptance.acceptance.', 'assets.acceptance.') where code like 'assets.acceptance.acceptance.%';
update system_popedom set code = replace(code, 'assets.query.query.', 'assets.query.') where code like 'assets.query.query.%';
update system_popedom set code = replace(code, 'assets.material.material.', 'assets.material.') where code like 'assets.material.material.%';

  select * from system_popedom
  where code like 'assets.acceptance.acceptance.%';

-- 查询有多少权限 重复执行了数据，并进行修订  【end】    注：此段select 和 update 得多次执行，确保select 查询结果都为0才正确--------

-- 查询有多少流程文件更新重复了，并进行修订  【start】      注：此段select 和 update 得多次执行，确保select 查询结果都为0才正确 --------
select count(*)
  from  wf_process
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and name like '%material%'
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.material.material.%'
union all
select count(*)
  from  wf_process
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and name like '%material%'
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.material.material.%'
union all
select count(*)
  from  wf_process
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.acceptance.acceptance.%'
union all
select count(*)
  from  wf_process
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.acceptance.acceptance.%'
union all
select count(*)
  from  wf_process
  where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.check.check.%'
union all
select count(*)
  from  wf_process
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.check.check.%'
union all
select count(*)
  from  wf_process
 where convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.finance.finance.%'
union all
select count(*)
  from  wf_process
 where convert_to_clob(content) like  '%clazz="cn.speedit.assets.finance.finance.%' 
union all
select count(*)
  from  wf_process
  where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.change.change.%'
union all
select count(*)
  from  wf_process
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and convert_to_clob(content) like '%clazz="cn.speedit.assets.change.change.%';
   
---  根据具体的查询结果，去更新数据

update wf_process
   set content = convert_to_blob(replace(convert_to_clob(content),
                                         'assignmentHandler="cn.speedit.assets.material.material.',
                                         'assignmentHandler="cn.speedit.assets.material.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and name like '%material%'
   and convert_to_clob(content) like
       '%assignmentHandler="cn.speedit.assets.material.material.%';
 update wf_process set
 content =
       convert_to_blob(replace(convert_to_clob(content),
                               'clazz="cn.speedit.assets.material.material.',
                               'clazz="cn.speedit.assets.material.'))
 where name in (select distinct code
                  from business_process
                 where system_product_code = 'assets')
   and name like '%material%'
   and convert_to_clob(content) like
       '%clazz="cn.speedit.assets.material.material.%';
   
-- 查询有多少流程文件更新重复了，并进行修订 【end】 --------
----------end  -------
commit;


----- 2019-04-23 补充、调整 ------
update system_view_config set page_code = regexp_replace(page_code, '^assets.change.change.', 'assets.change.') where product_code = 'assets' and page_code like 'assets.change.change.%';
update system_view_homepage set manager_page = regexp_replace(manager_page, 'e?page=assets.change.change.', 'e?page=assets.change.') where manager_page like 'e?page=assets.change.change.%';
update system_login_entry set manager_page = regexp_replace(manager_page, 'e?page=assets.change.change.', 'e?page=assets.change.') where manager_page like 'e?page=assets.change.change.%';
update system_login_entry set division_page = regexp_replace(division_page, 'e?page=assets.change.change.', 'e?page=assets.change.') where division_page like 'e?page=assets.change.change.%';
insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303070004, '清查统计权限', 'assets.check.common.business.check.task.statistic', null, 3030700, 4, null, 0, null, null, ',303070002,3030700,3030000,3000000,', null);
update system_popedom set code = regexp_replace(code,'^assets.query.','assets.check.') where id = 302091001;
insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3010399, '个人建账权限', 'assets.acceptance.personal.requestdep.requestdep.*', null, 3010300, 0, null, 0, null, null, ',3010399,3010300,3010000,3000000,', null);
insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (3040499, '验收建账主管权限', 'assets.acceptance.division.*', null, 3030400, 0, null, 0, null, null, ',3040499,3030400,3030000,3000000,', null);
delete from system_popedom where id = 301000904;
update system_popedom set code='assets.common.divisionhome' where id =3040409;
update system_popedom set code='assets.common.managerhome' where id =3020307;
update system_login_entry set manager_page='e?page=assets.common.managerhome',division_page='e?page=assets.common.division.index' where manager_page like '%e?page=assets.change.managerhome%' and division_page like '%e?page=assets.change.division.index%';
insert into SYSTEM_POPEDOM (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (302070002, '清查审核权限', 'assets.check.process.check.*', null, 3020700, 2, null, 0, null, null, ',302070002,3020700,3020000,3000000,', null);
update business_bill_template set path = '/product/assets/check/bill/jxls' || path where path not like '/product/assets%' and action like 'assets.check%';
update business_bill_template set path = '/product/assets/query/bill/jxls' || path where path not like '/product/assets%' and action like 'assets.query%';
insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303010104, '全校资产修改', 'assets.query.division.assets.modify', null, 3030101, null, null, 0, null, null, ',303010104,3030101,3030100,3030000,3000000,', null);
insert into system_popedom (ID, NAME, CODE, ICON, SYSTEM_POPEDOM_ID_PARENT, ORDER_NO, EVENT, IS_MENU, PLUGIN, ALIAS_NAME, PARENTS, DESCRIPTION)
values (303061001, '导出北化权限', 'assets.query.division.bhdata.*', null, 3030610, null, null, 0, null, null, ',303061001,3030610,3030600,3030000,3000000,', null);

update business_bill_template set path=regexp_replace(path,'/product/assets/change/','/product/assets/change/bill/jxls/') where id in(
select bbt.id from BUSINESS_BILL_config bbc left join BUSINESS_BILL_TEMPLATE bbt on bbc.business_bill_template_id=bbt.id left join business_bill bb on bb.id=bbc.business_bill_id 
where bb.system_product_code ='assets' and bb.business_code in ('lost','backstock','scrap','disposal_collection','repair','repairold','flittingout','cannibalize','sortchange','pricechange') and bbt.path not like '%bill/jxls%');
