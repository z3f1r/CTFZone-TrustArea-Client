package ctfz.trustarea.client.service.data

import android.content.Intent
import ctfz.trustarea.client.network.data.UserNetworkEntity


private const val EXTRA_USER_NAME = "USER_NAME"
private const val EXTRA_FIRST_NAME = "FIRST_NAME"
private const val EXTRA_LAST_NAME = "LAST_NAME"
private const val EXTRA_USERS = "USERS"


fun Intent.asUserNetworkEntity(): UserNetworkEntity {
    return UserNetworkEntity(
        username = this.getStringExtra(EXTRA_USER_NAME),
        first_name = this.getStringExtra(EXTRA_FIRST_NAME),
        last_name = this.getStringExtra(EXTRA_LAST_NAME)
    )
}


fun UserNetworkEntity.asIntent(intent: Intent): Intent {
    intent.putExtra(EXTRA_USER_NAME, this.username)
    intent.putExtra(EXTRA_FIRST_NAME, this.first_name)
    intent.putExtra(EXTRA_LAST_NAME, this.last_name)

    return intent
}

fun List<UserNetworkEntity>.asIntent(intent: Intent): Intent {
    intent.putExtra(EXTRA_USERS, ArrayList(this))

    return intent
}
