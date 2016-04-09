var cwd = process.cwd();
console.log('cwd:'+cwd);

//change to the parent directory
process.chdir('..');
console.log('cwd:'+process.cwd());

var content = 'output:hello';
process.stdout.write(content + '\n');

var errMsg = 'err:wrong';
process.stderr.write(errMsg + '\n');

