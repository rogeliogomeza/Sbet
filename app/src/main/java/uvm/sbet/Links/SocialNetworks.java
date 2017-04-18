package uvm.sbet.Links;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Rogelio on 17/04/2017.
 */

public class SocialNetworks {


    public SocialNetworks(final Context context, ImageButton ButtonInstagram, ImageButton ButtonTwitter, ImageButton ButtonFacebook){

        ButtonFacebook .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OpenFacebook(context);
                //startActivity(OpenSocialNetwork);
            }
        });

        ButtonTwitter .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OpenTwitter(context);
                //startActivity(OpenSocialNetwork);
            }
        });

        ButtonInstagram .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OpenInstagram(context);
                //startActivity(OpenSocialNetwork);
            }
        });

    }

    private void OpenFacebook(Context context){
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(context,"https://www.facebook.com/rga46","1364600832");
        facebookIntent.setData(Uri.parse(facebookUrl));
        context.startActivity(facebookIntent);
        //return facebookIntent;
    }

    private String getFacebookPageURL(Context context, String FACEBOOK_URL, String FACEBOOK_PAGE_ID) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://profile/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    private void OpenTwitter(Context context){

        Intent twitterIntent = new Intent(Intent.ACTION_VIEW);
        String twitterUrl = getTwitterPageURL(context,"https://www.twitter.com/normalwhiteguy_","535033575");
        twitterIntent.setData(Uri.parse(twitterUrl));
        context.startActivity(twitterIntent);
        //return twitterIntent;

    }

    private String getTwitterPageURL(Context context, String TWITTER_URL, String TWITTER_PAGE_ID) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.twitter.android", 0).versionCode;
            return "twitter://user?user_id=" + TWITTER_PAGE_ID;

        }catch (PackageManager.NameNotFoundException e) {
            return TWITTER_URL; //normal web url
        }
    }

    private void OpenInstagram(Context context){

        Intent instagramIntent = new Intent(Intent.ACTION_VIEW);
        String instagramUrl = getInstagramPageURL(context,"http://instagram.com/normalwhiteguy_","/_u/normalwhiteguy_");
        instagramIntent.setData(Uri.parse(instagramUrl));
        context.startActivity(instagramIntent);
        //return twitterIntent;

    }

    private String getInstagramPageURL(Context context, String INSTAGRAM_URL, String INSTAGRAM_PAGE_ID) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.instagram.android", 0).versionCode;
            return "http://instagram.com" + INSTAGRAM_PAGE_ID;

        }catch (PackageManager.NameNotFoundException e) {
            return INSTAGRAM_URL; //normal web url
        }
    }
}
