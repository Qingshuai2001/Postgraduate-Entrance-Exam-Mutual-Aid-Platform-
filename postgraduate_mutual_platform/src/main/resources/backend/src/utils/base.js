const base = {
    get() {
        return {
            url : "http://localhost:8080/postgraduate/",
            name: "postgraduate",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/postgraduate/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "考研互助平台"
        } 
    }
}
export default base
