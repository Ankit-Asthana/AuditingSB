# AuditingSB

//pattern to pass in add employee

{
    "userId":"Ankit",
    "employee":{
        "name":"Aryan",
        "doj":"10/04/2022",
        "dept":"DEV",
        "salary":50000
    }
}



//pattern to pass in update employee

http://localhost:8088/update/1/20000        //this is how to pass the id and salary to update of with the userId in body

{
    "userId":"Shubham"
}
