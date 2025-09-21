

database:
employee(id, name, salary, department)

select * from employees having min(salary) ;


select name, max(salary), department
group by name , department


select name, min(salary), department
from employee
group by name , salary
order by salary desc


---------
List
co-ordinates

find nearest co-ordinates from the list of user co-ord (input)

pojo
service
------------
----------------------------------

1. CoordinatesModel --> Record
   String x; ---> x axis
   String y;


1. class CoordinateUtil
hold -- >
Static List<CoordinatesModel> coord = List.of(
 new CoordinatesModel(4,5),
 new CoordinatesModel(8,4),
 new CoordinatesModel(5,5),
 new CoordinatesModel(2,9)
);



3. CoOrdinateController --> getNearestCoOrdinate

@Get (/getnearesrcorodinate)
accept --> CoordinateModel

4. CoordinateService
// read user corodinates
// call findNearesrCoordinates from Util


public List<CoordinatesModel> findNearesrCoordinates(CoordinatesModel coordinatesModel ){
 //  find nearesr Coordinates logic

 add.
}














