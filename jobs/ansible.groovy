new ansible.Builder(collectionName:'redhat-csp-download').build(this)
new ansible.Builder(collectionName:'jws-ansible-playbook').build(this)
new ansible.Builder(collectionName:'ansible_collections_jcliff').build(this)
EapView.jobList(this, 'Ansible Collections', 'ansible-collection-*')