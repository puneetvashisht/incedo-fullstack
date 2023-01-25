-- FETCH type lazy is same as @Fetch(SELECT)
select
        employee0_.id as id1_4_0_,
        employee0_.name as name2_4_0_ 
    from
        Employee_1 employee0_ 
    where
        employee0_.id=?
        

   select
        addresses0_.employee_id as employee4_0_0_,
        addresses0_.id as id1_0_0_,
        addresses0_.id as id1_0_1_,
        addresses0_.MY_CITY as MY_CITY2_0_1_,
        addresses0_.employee_id as employee4_0_1_,
        addresses0_.location as location3_0_1_ 
    from
        Address addresses0_ 
    where
        addresses0_.employee_id=?
        
 -- FETCH type eager @Fetch(JOIN)
            select
        employee0_.id as id1_4_0_,
        employee0_.name as name2_4_0_,
        addresses1_.employee_id as employee4_0_1_,
        addresses1_.id as id1_0_1_,
        addresses1_.id as id1_0_2_,
        addresses1_.MY_CITY as MY_CITY2_0_2_,
        addresses1_.employee_id as employee4_0_2_,
        addresses1_.location as location3_0_2_ 
    from
        Employee_1 employee0_ 
    left outer join
        Address addresses1_ 
            on employee0_.id=addresses1_.employee_id 
    where
        employee0_.id=?
        
         