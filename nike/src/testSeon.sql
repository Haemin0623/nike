     select	pd.*, 
           		uod.*, 
            	a.*, 
            	pp.*,
           		p.*
      from		product p,
            	product_photo pp, 
           		product_detail pd, 
           		(select * from user_order_detail where order_no=3) uod, 
            	address a, 
            	(select * from user_order where order_no=3) uo 
      where   	pd.product_detail_no=uod.product_detail_no 
         and uo.addr_no=a.addr_no 
         and pd.product_no=pp.product_no 
         and pd.product_no=p.product_no
         and batch = 1 
         and pd.color = pp.color;