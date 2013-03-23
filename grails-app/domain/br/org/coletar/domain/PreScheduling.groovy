package br.org.coletar.domain

import grails.validation.Validateable
import static org.joda.time.Days.days
import static org.joda.time.DateTime.now


@Validateable
class PreScheduling {

    //TODO:Business Rule - When create a preScheduling, automatically add closer collectStation from current address and collectItemType
    //TODO:Business Rule - When create a preScheduling, verify max and min values from collectStationSelected to validate prescheduling

    static final int MIN_DAYS_FOR_SCHEDULING = 1

    Date desiredDate
    Donator donator
    CollectItemType collectItemType
    Integer amount
    String phoneNumber
    Address address
    CollectStation collectionStation

    static constraints = {
        //current_date + MIN_DAYS_FOR_SCHEDULING days
        //TODO:change constant value, for a value from a propertie file
        desiredDate min: now().plus(days(MIN_DAYS_FOR_SCHEDULING)).withTimeAtStartOfDay().toDate()
        amount min: 1
        phoneNumber blank: false
    }
}
