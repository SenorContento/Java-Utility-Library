https://blog.serverdensity.com/how-to-create-a-debian-deb-package/

* Create control file in DEBIAN/control
* Type the below command (to generate md5sums) when the pwd is the debian package root directory
  * find . -type f ! -regex '.*.hg.*' ! -regex '.*?debian-binary.*' ! -regex '.*?DEBIAN.*' -printf '%P ' | xargs md5sum > DEBIAN/md5sums
* Create pre-post install and pre-post removal scripts in DEBIAN/
* cd to just outside package root directory and execute below command
  * dpkg -b $PACKAGE_ROOT_DIRECTORY $DEB_BEING_GENERATED
* Just install into your computer
  * sudo dpkg -i $DEB_BEING_GENERATED
