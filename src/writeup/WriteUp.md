# Project 1 (Zip) Write-Up #
--------

#### How Was Your Partnership? ####
-   Did both partners do an equal amount of work?  If not, why not?
    What happened?<pre>
**TODO**: answer this question
</pre> (Andrew's Response): Our partnership honestly went very well. We split up the work very evenly and so we were<br>
</pre> able to heavily dive into and focus on certain issues and errors that our code was having. Since we also had<br>
</pre> a very similar work schedule we could ask each other questions freqently and play off of each others knowledge<br>
</pre> of Java pretty well. The only issue we ran into was working with the github pushing and pulling commands. This<br>
</pre> frequently frustrated us as at one point we almost lost an entire worklist due to pushing and pulling complications.<br>
</pre> overall this partnership worked really well!<br>
</pre> <br>
</pre> (Chris's Response): I really enjoyed working with Andrew. He has a very different perspective on coding/problem solving than I do, and
 this project really gave me a chance to see how he works and learn from it so that I can improve. We ended up splitting the work
  pretty evenly, and we were both aware and on top of deadlines which was really nice. We also both have the same idea for how far
  ahead we want to be, which makes working together that much easier. We set aside a few afternoons and worked together on 
  the project. As Andrew said, GitHub was a bit frustrating. We very quickly figured out how we can't both work on the same file, 
  and we soon also realized how to use the version history tool in IntelliJ. Luckily, nothing was lost for long, but it still
  would have been nice if GitHub was a bit more forgiving with cooperative work. I really enjoyed pair-programming with Andrew, 
  and I hope I get a chance to again in the future. <br>
-----

#### Project Enjoyment ####
-   What was your favorite part of the project?  What was your least
    favorite part of the project?<pre>
**TODO**: Answer this question
</pre> (Andrew's Response): My favorite part of this project was the relief of seeing the tests all pass together.<br>
</pre> My least favorite part was the confusion on what things we were allowed to use and override and what we weren't<br>
</pre> It was pretty confusing in some areas.<br>
</pre> <br>
</pre> (Chris's Response): My favorite part of this assignment was implementing all of the different types of data structures.<br>
</pre> I also really enjoyed the pair programming. It was really interesting to see how many different types of data structures we could make.<br>
</pre> At times, the different things we needed to do were really confusing.<br> <br>


-   Did you enjoy the project?<pre>
**TODO**: Answer this question
</pre> (Andrew's Response): I did enjoy this project since the subject material was interesting and challenging.<br>
</pre> (Chris's Response): This was a fun project, and I enjoyed working on this with a partner. <br>

-----

#### WorkLists, Tries, and Zip ####
-   The ADT for a WorkList explicitly forbids access to the middle elements.  However, the FixedSizeFIFOWorkList has a peek(i) method
    which allows you to do exactly that.  Why is this an acceptable addition to the WorkList ADT in this particular case but not in general?<pre>
**TODO**: Answer this question
</pre> This is because the fixed size list has a definitive number of elements in the list and so, this method could potentially<br>
</pre> be O(1) time complexity rather than O(n) for every single element in the list to see whether or not it even exists.<br>
<br>
<br>
-   As we've described it, a `TrieMap` seems like a general-purpose replacement for `HashMap` or `TreeMap`.  Why might we still want to use one
    of these other data structures instead?<pre> 
**TODO**: Answer this question
</pre>Because a trieMap cannot be utilized for int based data but must be utilized with strings, hashmap and treemap can.<br>
<br>
<br>
-   One of the applications of Tries is in solving Word Searches.  A "word search" is an n x m rectangle of letters.  The goal is to find all
    of the possible words (horizontal, vertical, diagonal, etc.).  In Boggle, a similar game, any consecutive chain of letters (even repetitions)
    are allowed.  Explain (in very high-level psuedo-code) how you might solve this problem with a TrieSet or a TrieMap.  Make sure to detail
    how a similar solution that uses a HashSet/HashMap instead would be different and why using a Trie might make the solution better.<pre>
**TODO**: Answer this question
</pre> So, you'd have the TrieMap have a value at the final letter in each word and have the only nodes in the map lead to words. 
This is different than a HashSet/HashMap because these would have words with lots of overlap as two separate entries (For instance, 
Bat and Bats would have two separate entries instead of where they would share letters in a Trie). This takes up space that could
have been saved by using a Trie.<br>
<br>
<br>
-   One of the classes in the egr221a.main package is called Zip.  This class uses your PriorityQueue to do Huffman coding, your FIFOQueue as a buffer,
    your stack to calculate the keyset of a trie (using recursive backtracking), and your SuffixTrie to do LZ77Compression.  Find some text file
    (a free book from https://www.gutenberg.org/ or even the HTML of some website) and use Zip.java to zip it into a zip file.  Then, use a 
    standard zip utility on your machine (Finder on OS X, zip on Linux, WinZip or the like on Windows) to UNZIP your file.  Check that you got back
    the original.  Congratulations!  Your program correctly implements the same compression algorithm you have been using for years!  Discuss in a
    sentence or two how good the compression was and why you think it was good or bad.<pre>
**TODO**: Answer this question
</pre><br>
<br>
<br>
-   Now that you've played with Zip, we want you to do an **experiment** with Zip.  Notice that there is a constant called `BUFFER_LENGTH` in `Zip.java`.
    Higher values of this constant makes the compression algorithm that Zip uses use more memory and consequently more time.  The "compression ratio"
    of a file is the uncompressed size divided by the compressed size.  Compare time, space, type of input file, and compression ratio by running
    your code on various inputs.  We would like an in-depth analysis.  You should try at least one "book-like" file, at least one "website-like" file,
    and some other input of your choice.  We expect you to draw meaningful conclusions and possibly have graphs that convince us of your conclusions.
    This single question is worth almost as much as the implementation of `ArrayStack`; so, please take it seriously.  If you spend less than 20 minutes
    on this question, there is no conceivable way that you answered this question in the way we were intending.<pre>
**TODO**: Answer this question
</pre><br>

