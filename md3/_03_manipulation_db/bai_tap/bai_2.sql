use  sell_management;

-- hien thi thong tin oid,odate,oprice
SELECT order_id,order_date,order_price from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, 
-- và danh sách sản phẩm được mua bởi các khách
select customer_name
from customer
	inner JOIN `order` on customer.customer_id = `order`.customer_id;

SELECT product_name,customer_name,order_quantity
FROM product p
	INNER join order_details od on  p.product_id = od.product_id
    INNER join `order` o on od.order_id = o.order_id
    INNER JOIN customer c on o.customer_id = c.customer_id;
    
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào    
SELECT *
FROM customer c 
	LEFT JOIN `order` o on c.customer_id = o.customer_id
where o.customer_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)

SELECT `order`.order_id,`order`.order_date,sum(product.product_price * order_details.order_quantity) as order_price
FROM `order`
	inner join order_details  on `order`.order_id = order_details.order_id
    INNER join product on order_details.product_id= product.product_id
    GROUP BY order_details.order_id;



    