mkdir -p ~/git

cd ~/git

git clone https://github.com/swunait/dmit2015-fall2018term-repo.git dmit2015-instructor-repository

mkdir -p ~/git/my-dmit2015-repository

cd ~/git/dmit2015-instructor-repository

git pull

cp -R dmit2015-assignment01-start ~/git/my-dmit2015-repository

cd ~/git/my-dmit2015-repository

cp -R dmit2015-assignment01-start dmit2015-assignment01-yourname (replace yourname with your full name, ex. johnsmith)

cd ~/git

git clone https://github.com/yourAccountName/my-dmit2015-repository.git

git add dmit2015-assignment01-yourname

git commit -m "first commit"

git remote add origin https://github.com/yourAccountName/my-dmit2015-repository.git

git push -u origin master

# Open Eclipse and Import the dmit2015-assignment01-yourname project
