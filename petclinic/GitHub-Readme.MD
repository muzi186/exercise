echo "# petclinic" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/gavin2lee/petclinic.git
git push -u origin master


git config --global user.name "your-username"
git config --global user.email "your-email"

git config --list