package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    //  FILTROS
    Optional<Employee> findByEmail(String email);
    List<Employee> findAllByMarriedTrue();
    List<Employee> findAllByMarriedFalse();

    List<Employee> findAllByName(String name);
    @Query(value = "{'name' :  ?0}")
    List<Employee> findAllByNameQuery(String name);

    List<Employee> findAllByBirthDateAfter(LocalDate birthDate);

    // El $0 indica la posicion del objeto que coge respecto al metodo find....(LocalDate $0, String $1....)
    @Query("""
        {
            "birthDate": {
                "$gte": {
                "$date" : "?0"
                }
            }
        }
    """)
    List<Employee> findAllByBirthDateAfterQuery(LocalDate birthDate);

    @Query("""
        {
            "initDate": {
                "$gte": {
                "$date" : "?0"
                }
            },
            "endDate": {
                "$lte": {
                "$date" : "?1"
                }
            }
        }
    """)
    List<Employee> findAllByInitAndEndDatesQuery(LocalDate init, LocalDate end);

    @Query(value = "{'birthDate' : {$gte :  ?0, $lte :  $1}}")
    List<Employee> findAllByBirthDateBetweenQuery(LocalDate minDate, LocalDate maxDate);


    // PROYECCIONES

    // Si se le pone 1 o 0 indica si se activa o se desactiva un campo
    // El id lo muestra siempre a menos que lo excluyamos con un 0
    @Query(value = "{}", fields = "{name: 1}")
    List<Employee> findAllIdAndName();

    @Query(value = "{}", fields = "{name: 1, email: 1}")
    List<Employee> findAllIdAndNameAndEmail();

    @Query(value = "{}", fields = "{ _id: 0, name: 1, email: 1}")
    List<Employee> findNameAndEmailExcludingId();
}
