package br.org.coletar.domain



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ItemTypeLimitsForCollectStation)
@Mock([CollectStation, CollectItemType])
class ItemTypeLimitsForCollectStationTests {


    void testConstraintCollectionStationCollectItemTypeUniqueFail() {

        def existentCollectionStation = new CollectStation()
        def existentCollectItemType = new CollectItemType()

        //create existent ItemTypeLimitsForCollectStation
        def existentCollectionStationItemTypeLimits =
            new ItemTypeLimitsForCollectStation(collectItemType: existentCollectItemType,
                                                collectionStation: existentCollectionStation,
                                                minLimit: 1,
                                                maxLimit: 1)

        mockForConstraintsTests(ItemTypeLimitsForCollectStation,[existentCollectionStationItemTypeLimits])

        def newCollectionStationItemTypeLimits =
            new ItemTypeLimitsForCollectStation(collectItemType: existentCollectItemType,
                    collectionStation: existentCollectionStation,
                    minLimit: 5,
                    maxLimit: 7)

        assert !newCollectionStationItemTypeLimits.validate()
        assert newCollectionStationItemTypeLimits.errors.errorCount == 1
        assert "unique" == newCollectionStationItemTypeLimits.errors["collectionStation"]
    }

    void testConstraintCollectionStationCollectItemTypeUniqueSuccess() {

        def existentCollectionStation = new CollectStation()
        def existentCollectItemType = new CollectItemType()

        //create existent ItemTypeLimitsForCollectStation
        def existentCollectionStationItemTypeLimits =
            new ItemTypeLimitsForCollectStation(collectItemType: existentCollectItemType,
                    collectionStation: existentCollectionStation,
                    minLimit: 1,
                    maxLimit: 1)

        mockForConstraintsTests(ItemTypeLimitsForCollectStation,[existentCollectionStationItemTypeLimits])

        def newCollectionStationItemTypeLimits =
            new ItemTypeLimitsForCollectStation(collectItemType: new CollectItemType(),
                    collectionStation: new CollectStation(),
                    minLimit: 5,
                    maxLimit: 7)

        assert newCollectionStationItemTypeLimits.validate()
    }
}
