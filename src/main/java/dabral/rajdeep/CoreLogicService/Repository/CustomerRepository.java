package dabral.rajdeep.CoreLogicService.Repository;


import dabral.rajdeep.CoreLogicService.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findByEmail(String email);
//
//    @Query(value = "select user_id from address where id = :addressId ", nativeQuery = true)
//    public Integer findUserId(@Param("addressId") Integer id);
//
//    @Modifying
//    @Query(value = "Delete from address where id =:addressId ", nativeQuery = true)
//    public void deleteAddress(@Param("addressId") Integer id);
//
//    /*
//    getting specific details of customer by Admin using Projection interface with pagination.
//     */
//    @Query("select c.id as id , c.email as email , CONCAT(c.firstName ,c.middleName ,c.lastName ) as fullName" +
//            " , c.isActive as isActive from Customer c ")
//    public Page<DisplayRegisterCustomer> getAllCustomer(Pageable pageable);
}
