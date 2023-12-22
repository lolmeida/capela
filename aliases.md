
# Example aliases
| aliases     | command                                                              |
|-------------|----------------------------------------------------------------------|
| zshconfig   | code ~/.zshrc                                                        |
| myzsh       | code ~/.oh-my-zsh                                                    |
| peah_ls     | ls -lart                                                             |
| mvnskiptest | /mvnw test -Dcheckstyle.skip -Dformat.skip -Dvulnerabilitycheck.skip |



# Kubectl
| aliases | command                        |
|---------|--------------------------------|
| k       | kubectl                        |
| kga     | kubectl get all -o wide        |
| kgn     | kubectl get node -o wide       |
| kgp     | kubectl get pod -o wide        |
| kgs     | kubectl get svc -o wide        |
| kgd     | kubectl get deployment -o wide |
| kgr     | kubectl get replicaset -o wide |






# Aws aliases
| aliases   | command                                                                |
|-----------|------------------------------------------------------------------------|
| aws       | docker run --rm -it -v ~/.aws:/root/.aws -v $(pwd):/aws amazon/aws-cli |
| awsl      | awslocal                                                               |
| awsls3    | awslocal s3                                                            |
| awslambda | awslocal lambda                                                        |


# ssh aliases
| aliases | command                                                         |
|---------|-----------------------------------------------------------------|
| ssh     | ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null |
| sshdev  | ssh -i ~/.ssh/id_rsa_dev                                        |
| sshprod | ssh -i ~/.ssh/id_rsa_prod                                       |
| sshstg  | ssh -i ~/.ssh/id_rsa_stg                                        |
| sshqa   | ssh -i ~/.ssh/id_rsa_qa                                         |



# Some aliases
| aliases | command                |
|---------|------------------------|
| ll      | ls -l                  |
| la      | ls -a                  |
| lla     | ls -la                 |
| l       | ls -CF                 |
| ..      | cd ..                  |
| ...     | cd ../..               |
| ....    | cd ../../..            |
| .....   | cd ../../../..         |
| c       | clear                  |
| h       | history                |
| j       | jobs -l                |
| p       | ps -ef '\|' grep -i    |           
| path    | echo -e ${PATH//:/\\n} |
| now     | date +"%T"             |
| nowtime | now                    |
| nowdate | date +"%d-%m-%Y"       |
| vi      | vim                    |
| svi     | sudo vi                |
| vis     | vim "+set si"          |
| edit    | vim                    |
| ports   | netstat -tulanp        |
| myip    | curl ip.appspot.com    |
| wget    | wget -c                |


# Git aliases
| aliases | command                                                                                                                         |
|---------|---------------------------------------------------------------------------------------------------------------------------------|
| gaa     | git add --all                                                                                                                   |
| gau     | git add --update                                                                                                                |
| gacp    | git add --all && git commit -m                                                                                                  |
| gb      | git branch                                                                                                                      |
| gbr     | git branch --remote                                                                                                             |
| ggsup   | git branch --set-upstream-to=origin/$(git_current_branch)                                                                       |
| gco     | git checkout                                                                                                                    |
| gcb     | git checkout -b                                                                                                                 |
| gcod    | git checkout develop                                                                                                            |
| gcom    | git checkout master                                                                                                             |
| gcp     | git cherry-pick                                                                                                                 |
| gcpa    | git cherry-pick --abort                                                                                                         |
| gcpc    | git cherry-pick --continue                                                                                                      |
| gcim    | git commit --amend --reset-author --no-edit                                                                                     |
| gd      | git diff                                                                                                                        |
| gdt     | git diff-tree --no-commit-id --name-only -r                                                                                     |
| gf      | git fetch                                                                                                                       |
| gfo     | git fetch origin                                                                                                                |
| ggraph  | git log --graph --color --decorate --oneline --all                                                                              |
| glgga   | git log --graph --decorate --all                                                                                                |
| glgm    | git log --graph --max-count=10 --pretty=format:"%C(yellow)%h%Creset%C(auto)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset" |
| glol    | git log --graph --pretty=                                                                                                       |
| glo     | git log --oneline --decorate --color                                                                                            |
| glg     | git log --stat --max-count=10                                                                                                   |
| gm      | git merge                                                                                                                       |
| gmom    | git merge origin/master                                                                                                         |
| gmum    | git merge upstream/master                                                                                                       |
| glar    | for d in *; do pushd $d; git pull; popd; done                                                                                   |
| gl      | git pull                                                                                                                        |
| ggpull  | git pull origin "$(git_current_branch)"                                                                                         |
| glum    | git pull upstream master                                                                                                        |
| gp      | git push                                                                                                                        |
| gpd     | git push --dry-run                                                                                                              |
| gpf     | git push --force-with-lease                                                                                                     |
| gpsup   | git push --set-upstream origin $(git_current_branch)                                                                            |
| ggpush  | git push origin "$(git_current_branch)"                                                                                         |
| gpu     | git push upstream                                                                                                               |
| grb     | git rebase                                                                                                                      |
| grba    | git rebase --abort                                                                                                              |
| grbc    | git rebase --continue                                                                                                           |
| grbs    | git rebase --skip                                                                                                               |
| gr      | git remote                                                                                                                      |
| grv     | git remote -v                                                                                                                   |
| gra     | git remote add                                                                                                                  |
| grao    | git remote add origin                                                                                                           |
| grrm    | git remote remove                                                                                                               |
| grrmo   | git remote origin                                                                                                               |
| grmv    | git remote rename                                                                                                               |
| grset   | git remote set-url                                                                                                              |
| grup    | git remote update                                                                                                               |
| grh     | git reset HEAD                                                                                                                  |
| grhh    | git reset HEAD --hard                                                                                                           |
| gsps    | git show --pretty=short --show-signature                                                                                        |
| gsta    | git stash                                                                                                                       |
| gst     | git status                                                                                                                      |
| gsi     | git submodule init                                                                                                              |
| gsu     | git submodule update                                                                                                            |
| gss     | git submodule status                                                                                                            |
| gitsub  | git submodule deinit -f --all && git submodule init && git submodule update --remote                                            |


# Kubernetes aliases
| kctx     | config use-context   |
|----------|----------------------|
| kcreate  | kubectl create       |
| kdel     | kubectl delete       |
| kdesc    | kubectl describe     |
| kedit    | kubectl edit         |
| kex      | kubectl exec -it     |
| kget     | kubectl get          |
| kpod     | kubectl get pods     |
| ksvc     | kubectl get services |
| k        | kubectl              |
| klogs    | kubectl logs         |
| kreplace | kubectl replace      |
| krollout | kubectl rollout      |
| krun     | kubectl run          |
| kscale   | kubectl scale        |
| kset     | kubectl set          |
| ktop     | kubectl top          |



# Docker aliases
| aliases   | command                                                                                                                  |
|-----------|--------------------------------------------------------------------------------------------------------------------------|
| dc        | docker-compose                                                                                                           |
| dce       | docker-compose exec                                                                                                      |
| d         | docker                                                                                                                   |
| di        | docker images                                                                                                            |
| dps       | docker ps                                                                                                                |
| dpsa      | docker ps -a                                                                                                             |
| dpa       | docker ps -a                                                                                                             |
| drm       | docker rm                                                                                                                |
| drmv      | docker rm $(docker ps -a -q -f status=exited -f status=created)                                                          |
| drmf      | docker rm $(docker ps -a -q -f status=exited)                                                                            |
| dkstall   | docker stop $(docker ps -q)                                                                                              |
| dkrmall   | docker rm $(docker stop  $(docker ps -aq))                                                                               |
| dclean    | docker rm $(docker ps -a -q) && docker rmi $(docker images -q)                                                           |
| dcleanall | docker rm $(docker ps -a -q) && docker rmi $(docker images -q) && docker volume rm $(docker volume ls -qf dangling=true) |
| drmi      | docker rmi                                                                                                               |
| dcleani   | docker rmi $(docker images -q)                                                                                           |
| dcr       | docker run                                                                                                               |
| drun      | docker run                                                                                                               |
| dcrun     | docker run --rm                                                                                                          |
| dcleanv   | docker volume rm $(docker volume ls -qf dangling=true)                                                                   |