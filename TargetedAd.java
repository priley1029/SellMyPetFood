/*
 * Problem 2 Sell My Pet Food
 */
public class TargetedAd
{

  public static void main(String[] args)
  {
    DataCollector collector = new DataCollector();
    collector.setData("socialMediaPosts.txt", "targetWords.txt");
//Creates DataCollector Object and sets the required data.
    

String users = "";
//Empty string which will contain usernames.

    for (int i = 0; i < 39; i++)
    {
      String currentPost = collector.getNextPost();
      //String containing the post.
      boolean found = false;
      //Boolean which changes depending on whether or not the word was found in the post.

      for (int j = 0; j < 20; j ++)
      {
        String word = collector.getNextTargetWord();
        //String containing each of the 20 words which updates as the loop progresses.
        if(currentPost.indexOf(word) >= 0)
        {
              found = true;
              //If the word is found, the boolean is updated.
           if(currentPost.contains("hotdog") || currentPost.contains("Hotdog"))
           {
              found = false;
           }
        }
      }
      
      if (found == true)
      {
        users += currentPost.substring(0, currentPost.indexOf(" ")) + " ";
        //Adds the username to the list if the boolean is true.
      }
    }

    collector.prepareAdvertisement("advertisement.txt", users, "Do you want your pets to be healthy? Buy Blue Buffalo pet food, suitable for both cats and dogs!");
    //Creates the targeted advertisement.
  }
  

}