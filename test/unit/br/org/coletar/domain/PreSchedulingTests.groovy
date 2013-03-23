package br.org.coletar.domain


import static br.org.coletar.domain.PreScheduling.MIN_DAYS_FOR_SCHEDULING
import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PreScheduling)
@Mock([PreScheduling,Donator,CollectItemType,Address,CollectStation])
class PreSchedulingTests {

    void testConstraintDesiredDateTestFail(){

        Date now = new Date()

        //prepare MOC for testing
        mockForConstraintsTests(PreScheduling)

        PreScheduling preScheduling = new PreScheduling(desiredDate: now,
                                                        donator: new Donator(),
                                                        collectItemType: new CollectItemType(),
                                                        amount: 50,
                                                        phoneNumber: "22222222",
                                                        address: new Address(),
                                                        collectionStation: new CollectStation())
        assert !preScheduling.validate()
        assert preScheduling.errors.errorCount == 1
        assert "min" == preScheduling.errors["desiredDate"]
    }

    void testConstraintDesiredDateTestSuccess(){

        Date tomorrow = new Date((new Date()).time + (1000*60*60*24*MIN_DAYS_FOR_SCHEDULING))

        //prepare MOC for testing
        mockForConstraintsTests(PreScheduling)

        PreScheduling preScheduling = new PreScheduling(desiredDate: tomorrow,
                donator: new Donator(),
                collectItemType: new CollectItemType(),
                amount: 50,
                phoneNumber: "22222222",
                address: new Address(),
                collectionStation: new CollectStation())

        assert preScheduling.validate()
    }


}
