package br.org.coletar.domain



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ItemTypeLimitsForCollectStation)
@Mock([CollectStation, CollectItemType])
class ItemTypeLimitsForCollectStationTests {


    void testConstraintCollectionStationCollectItemTypeUniqueFail() {

        def existentCollectStation = new CollectStation()
        def existentCollectItemType = new CollectItemType()

        //create existent ItemTypeLimitsForCollectStation
        def existentItemTypeLimitsForCollectStation =
            new ItemTypeLimitsForCollectStation(collectItemType: existentCollectItemType,
                                                collectStation: existentCollectStation,
                                                minLimit: 1,
                                                maxLimit: 1)

        mockForConstraintsTests(ItemTypeLimitsForCollectStation,[existentItemTypeLimitsForCollectStation])

        def newItemTypeLimitsForCollectStation =
            new ItemTypeLimitsForCollectStation(collectItemType: existentCollectItemType,
                    collectStation: existentCollectStation,
                    minLimit: 5,
                    maxLimit: 7)

        assert !newItemTypeLimitsForCollectStation.validate()
        assert newItemTypeLimitsForCollectStation.errors.errorCount == 1
        assert "unique" == newItemTypeLimitsForCollectStation.errors["collectStation"]
    }

    void testConstraintCollectionStationCollectItemTypeUniqueSuccess() {

        def existentCollectStation = new CollectStation()
        def existentCollectItemType = new CollectItemType()

        //create existent ItemTypeLimitsForCollectStation
        def existentItemTypeLimitsForCollectStation =
            new ItemTypeLimitsForCollectStation(collectItemType: existentCollectItemType,
                    collectStation: existentCollectStation,
                    minLimit: 1,
                    maxLimit: 1)

        mockForConstraintsTests(ItemTypeLimitsForCollectStation,[existentItemTypeLimitsForCollectStation])

        def newItemTypeLimitsForCollectStation =
            new ItemTypeLimitsForCollectStation(collectItemType: new CollectItemType(),
                    collectStation: new CollectStation(),
                    minLimit: 5,
                    maxLimit: 7)

        assert newItemTypeLimitsForCollectStation.validate()
    }
}
