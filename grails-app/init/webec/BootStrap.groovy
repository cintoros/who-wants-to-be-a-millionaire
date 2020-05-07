package webec

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.PRODUCTION) {
            return
        }

        Role adminRole = save(Role.findOrCreateWhere(authority: Role.ADMIN))
        Role playerRole = save(Role.findOrCreateWhere(authority: Role.PLAYER))

        // must use longer passwords due to configured password constrains.
        // username cannot be user due to configured username constraints.
        User player = save(new User(username: 'player', password: 'player123'))
        User admin = save(new User(username: 'admin', password: 'admin123'))

        UserRole.create(player, playerRole, true)
        UserRole.create(admin, adminRole, true)

        // plausibility check
        assert Role.count() == 2
        assert User.count() == 2
        assert UserRole.count() == 2
    }

    static save(domainObject) {
        domainObject.save(failOnError: true)
    }

    def destroy = {
    }
}
