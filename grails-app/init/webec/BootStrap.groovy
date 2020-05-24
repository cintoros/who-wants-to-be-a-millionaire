package webec

class BootStrap {

    def init = { servletContext ->
        // comment out production questions for easier development
        UtilityService.loadProductionQuestions()

        Role adminRole = UtilityService.save(Role.findOrCreateWhere(authority: Role.ADMIN))
        Role playerRole = UtilityService.save(Role.findOrCreateWhere(authority: Role.PLAYER))

        // must use longer passwords due to configured password constrains.
        // username cannot be user due to configured username constraints.
        User player = UtilityService.save(new User(username: 'player', password: 'player123'))
        User admin = UtilityService.save(new User(username: 'admin', password: 'admin123'))

        UserRole.create(player, playerRole, true)
        UserRole.create(admin, adminRole, true)

        // plausibility check
        assert Role.count() == 2
        assert User.count() == 2
        assert UserRole.count() == 2

        // comment in dev questions for easier development
        UtilityService.loadDevelopmentQuestions()
    }


    def destroy = {
        // empty
    }
}
