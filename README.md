rss2mobile-site
===============

Utility to convert RSS feed to mobile (view-able) web site. 

Code licensed under <a href="http://www.gnu.org/licenses/gpl-2.0.html">GNU General Public License, version 2</a>

Written by Lorin M Klugman

Uses 
<a href="http://twitter.github.io/bootstrap/">Twitter Bootstrap Frontend Framwork</a><br/>
<a href='http://commons.apache.org/proper/commons-io/'>Apache Commons IO</a><br/>
<a href="http://commons.apache.org/proper/commons-lang/">Apache Commons Lang</a></br>
<a href="http://ant.apache.org/">Apache Ant</a> to build.

To build run ant make-dist

To run:<br/>
    cd dist<br/>
    java -jar rss2MobileSite.jar -src "../feed-data/05-28-13-rss.xml" -out 05-28-13

View and verify:<br/>
    Use your web browser and open file://<path to>/05-28-13/index.html



Note! Sample data is provided in the static-content and feed-data directories.<br/>

You can delete the contents of static-content or replace the contents in order to customize.<br/>
You can delete the feed-data directory. Supplied only as a sample use.
