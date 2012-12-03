package coletar

import grails.validation.Validateable

@Validateable
class Donator {

    User user

    static constraints = {
        user blank: false
    }

}
