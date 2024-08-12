

const NewCommitSection = () => {
    return(<div  className='app-new'>
        <label className="app-new-line-name">Commit id</label><input type="text" className="app-new-line-input"/>
        <label className="app-new-line-name">Username</label><input type="text" className="app-new-line-input"/>
        <label className="app-new-line-name">Repository id</label><input type="text" className="app-new-line-input"/>
        <label className="app-new-line-name">Key words</label><input type="text" className="app-new-line-input"/>
        <label className="app-new-line-name">Description</label><input type="text" className="app-new-line-input"/>
        <button className="app-new-line-button" type="button" >Add new</button>
    </div>);
}


export default NewCommitSection;