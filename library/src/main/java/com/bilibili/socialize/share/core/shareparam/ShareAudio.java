/*
 * Copyright (C) 2015 Bilibili <jungly.ik@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bilibili.socialize.share.core.shareparam;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Jungly
 * @email jungly.ik@gmail.com
 * @since 2015/10/8 22:31
 */
public class ShareAudio implements Parcelable {

    private ShareImage mThumb;
    private String mAudioSrcUrl;
    private String mAudioH5Url;
    private String mDescription;

    public ShareAudio() {
    }

    public ShareAudio(String audioSrcUrl, String audioH5Url, String description) {
        mAudioSrcUrl = audioSrcUrl;
        mAudioH5Url = audioH5Url;
        mDescription = description;
    }

    public ShareAudio(ShareImage thumb, String audioSrcUrl, String description) {
        mThumb = thumb;
        mAudioSrcUrl = audioSrcUrl;
        mDescription = description;
    }

    public ShareImage getThumb() {
        return mThumb;
    }

    public void setThumb(ShareImage thumb) {
        mThumb = thumb;
    }

    public String getAudioSrcUrl() {
        return mAudioSrcUrl;
    }

    public void setAudioSrcUrl(String audioSrcUrl) {
        mAudioSrcUrl = audioSrcUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getAudioH5Url() {
        return mAudioH5Url;
    }

    public void setAudioH5Url(String audioH5Url) {
        mAudioH5Url = audioH5Url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mThumb, 0);
        dest.writeString(mAudioSrcUrl);
        dest.writeString(mAudioH5Url);
        dest.writeString(mDescription);
    }

    protected ShareAudio(Parcel in) {
        mThumb = in.readParcelable(ShareImage.class.getClassLoader());
        mAudioSrcUrl = in.readString();
        mAudioH5Url = in.readString();
        mDescription = in.readString();
    }

    public static final Creator<ShareAudio> CREATOR = new Creator<ShareAudio>() {
        public ShareAudio createFromParcel(Parcel source) {
            return new ShareAudio(source);
        }

        public ShareAudio[] newArray(int size) {
            return new ShareAudio[size];
        }
    };
}
