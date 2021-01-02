package webec

class BootStrap {
    def utilityService
    def init = { servletContext ->
        // comment out production questions for easier development
        if (Question.count() <= 50) {
            utilityService.loadProductionQuestions()
        }
        if (User.count() <= 0) {
            Role adminRole = utilityService.save(Role.findOrCreateWhere(authority: Role.ADMIN))
            Role playerRole = utilityService.save(Role.findOrCreateWhere(authority: Role.PLAYER))
            // must use longer passwords due to configured password constrains.
            // username cannot be user due to configured username constraints.
            User player = utilityService.save(new User(username: 'player', password: 'player123'))
            User admin = utilityService.save(new User(username: 'admin', password: 'admin123'))
            UserRole.create(player, playerRole, true)
            UserRole.create(admin, adminRole, true)
            // plausibility check
            assert Role.count() == 2
            assert User.count() == 2
            assert UserRole.count() == 2
        }
    }
    def destroy = {
    }
}
