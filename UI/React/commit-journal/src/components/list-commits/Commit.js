const  Commit = ({element}) => {
    return (
        <div key={element.id}>
            <label>Id: {element.id}</label>
            <label>Commit id: {element.commitId}</label>
            <label>Username: {element.userName}</label>
            <label>Repository Id: {element.repoId}</label>
            <label>Memo Tags: {element.memoTags.map((el)=>{return <div key={el}>{el}</div>})}</label>
            <label>Description: {element.description}</label>
        </div>

    );
}


export default Commit;
