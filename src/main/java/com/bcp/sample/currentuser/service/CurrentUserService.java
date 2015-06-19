package com.bcp.sample.currentuser.service;

import com.bcp.sample.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
