/*
 * This file is part of Adblock Plus <https://adblockplus.org/>,
 * Copyright (C) 2006-present eyeo GmbH
 *
 * Adblock Plus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as
 * published by the Free Software Foundation.
 *
 * Adblock Plus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Adblock Plus.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.adblockplus.android;

import org.adblockplus.libadblockplus.UpdateCheckDoneCallback;
import org.apache.commons.lang.StringUtils;

import android.content.Context;
import android.util.Log;

public class AndroidUpdateCheckDoneCallback extends UpdateCheckDoneCallback
{
  private static final String TAG = Utils.getTag(AndroidUpdateCheckDoneCallback.class);

  private final Context context;

  public AndroidUpdateCheckDoneCallback(final Context context)
  {
    this.context = context;
  }

  @Override
  public void updateCheckDoneCallback(final String error)
  {
    if (StringUtils.isEmpty(error))
      return;
    Log.e(TAG, "Update check failed: " + error);
    Utils.showUpdateNotification(this.context, null, error);
  }
}
